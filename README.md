## smooks-editor

[**Download p2-repository**][download-site]

Eclipse based ( indigo ) graphical smooks editor
This is a fork from [jboss tools repo][jboss-smooks-editor].

## Build

For the moment it can be buit only from eclipse.

 - download eclipse indigo
 - install m2e
 - import project
 - import target configuration **indigo-target** from target-platform directory
 - import plugins
 - import features
 - open site.xml from **site** directory
 - click on build all
 - the site will be generated in **site** directory
 - Open Help -> Install new Software -> click add -> local -> navigate to site directory from above -> install all
 - Done

## Goals

 - Make compile only with maven
 - Add smooks 1.5
 - fix tests
 - port to eclipse 4.x ( maybe with compatibility layer )

## Resources

 - [html guide here][html-guide]
 - [video tutorial here][video-guide]


[jboss-smooks-editor]: https://github.com/jbosstools/jbosstools-full-svn-mirror/tree/3.3.indigo/smooks "Smooks Editor"
[html-guide]: http://docs.jboss.org/tools/OLD/3.1.0.GA/en/jboss_smooks_plugin_ref_guide/html_single/index.html "Html guide"
[video-guide]: http://www.smooks.org/mediawiki/index.php?title=Eclipse_IDE "Video guide"
[download-site]: https://github.com/alexproca/smooks-editor/releases/download/working-eclipse/site.zip "P2 Site"
