#!/bin/bash
# Hudson creates a repo in ${repoDir}; copy it into other places for access by downstream jobs and users

# defaults for JBoss Tools
targetZipFile=e37M5-wtp33M5.target
repoDir=/home/hudson/static_build_env/jbds/tools/sources/REPO
destinationPath=/home/hudson/static_build_env/jbds/target-platform
DESTINATION=tools@filemgmt.jboss.org:/downloads_htdocs/tools/updates/target-platform
include="*"
exclude="--exclude '.blobstore'" # exclude the .blobstore

while [ "$#" -gt 0 ]; do
	case $1 in
		'-targetFile') targetZipFile="$2"; shift 2;; # old flag name (collision with build.xml's ${targetFile}, which points to a .target file)
		'-targetZipFile') targetZipFile="$2"; shift 2;;
		'-repoPath') repoDir="$2"; shift 2;; # old flag name (refactored to match build.xml's ${repoDir})
		'-repoDir') repoDir="$2"; shift 2;;
		'-destinationPath') destinationPath="$2"; shift 2;;
		'-DESTINATION') DESTINATION="$2"; shift 2;;
		'-include') include="$2"; shift 2;;
		'-exclude') exclude="$2"; shift 2;;
		'-jbt_3.3.indigo') 
		# defaults for JBT (trunk)
		targetZipFile=e37M5-wtp33M5.target
		repoDir=/home/hudson/static_build_env/jbds/tools/sources/REPO_3.3.indigo
		destinationPath=/home/hudson/static_build_env/jbds/target-platform_3.3.indigo
		DESTINATION=tools@filemgmt.jboss.org:/downloads_htdocs/tools/updates/target-platform_3.3.indigo
		include="*"
		exclude="--exclude '.blobstore'" # exclude the .blobstore
		shift 1;;
		'-jbt') 
		# defaults for JBT (stable branch)
		targetZipFile=e37M5-wtp33M5.target
		repoDir=/home/hudson/static_build_env/jbds/tools/sources/REPO
		destinationPath=/home/hudson/static_build_env/jbds/target-platform
		DESTINATION=tools@filemgmt.jboss.org:/downloads_htdocs/tools/updates/target-platform
		include="*"
		exclude="--exclude '.blobstore'" # exclude the .blobstore
		shift 1;;
		'-jbds_3.3.indigo') 
		# defaults for JBDS (trunk)
		targetZipFile=jbds500-e37M5-wtp33M5.target
		repoDir=/home/hudson/static_build_env/jbds/tools/sources/JBDS-REPO_3.3.indigo
		destinationPath=/home/hudson/static_build_env/jbds/jbds-target-platform_3.3.indigo
		DESTINATION=/qa/services/http/binaries/RHDS/updates/jbds-target-platform_3.3.indigo
		include=".blobstore *" # include the .blobstore
		exclude="" 
		shift 1;;
		'-jbds') 
		# defaults for JBDS (stable branch)
		targetZipFile=jbds500-e37M5-wtp33M5.target
		repoDir=/home/hudson/static_build_env/jbds/tools/sources/JBDS-REPO
		destinationPath=/home/hudson/static_build_env/jbds/jbds-target-platform
		DESTINATION=/qa/services/http/binaries/RHDS/updates/jbds-target-platform
		include=".blobstore *" # include the .blobstore
		exclude="" 
		shift 1;;
	esac
done

if [[ -d ${repoDir} ]]; then
	cd ${repoDir}

	if [[ ! -d ${destinationPath}/${targetZipFile} ]]; then 
		mkdir -p ${destinationPath}/${targetZipFile}
	fi
	du -sh ${repoDir} ${destinationPath}/${targetZipFile}

	# copy/update into central place for reuse by local downstream build jobs
	date; rsync -arzqc --delete-after --delete-excluded --rsh=ssh ${exclude} ${include} ${destinationPath}/${targetZipFile}/

	du -sh ${repoDir} ${destinationPath}/${targetZipFile}

	# upload to http://download.jboss.org/jbossotools/updates/target-platform_3.3.indigo/latest/ for public use
	if [[ ${DESTINATION/@/} == ${DESTINATION} ]]; then # local path, no user@server
		mkdir -p ${DESTINATION}/
	fi
	# if the following line fails, make sure that ${DESTINATION} is already created on target server
	date; rsync -arzqc --delete-after --delete-excluded --rsh=ssh ${exclude} ${include} ${DESTINATION}/latest/

	targetZip=/tmp/${targetZipFile}.zip

	# create zip, then upload to http://download.jboss.org/jbossotools/updates/target-platform_3.3.indigo/${targetZipFile}.zip for public use
	zip -q -r9 ${targetZip} ${include}
	du -sh ${targetZip}

	# generate MD5 sum for zip (file contains only the hash, not the hash + filename)
	for m in $(md5sum ${targetZip}); do if [[ $m != ${targetZip} ]]; then echo $m > ${targetZip}.MD5; fi; done

	date; rsync -arzq --rsh=ssh ${targetZip} ${targetZip}.MD5 ${DESTINATION}/ 
	rm -f ${targetZip} ${targetZip}.MD5
fi
