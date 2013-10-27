<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="xml" indent="yes" encoding="UTF-8"
		version="1.0" />
	<xsl:decimal-format decimal-separator="."
		grouping-separator="," />

	<!-- should we include {@version} for specific ver, or 0.0.0 for latest 
		avail? -->
	<xsl:param name="useLatest" select="'true'" />

	<xsl:variable name="platformFilter"
		select="concat(/target/environment/os/text(), ',', /target/environment/ws/text(), ',', /target/environment/arch/text())" />

	<xsl:template match="target">
		<site>
			<description>JBoss Tools Target Platform Update Site / p2 Repo</description>
			<category-def name="TargetPlatform" label="TargetPlatform">
				<description>JBoss Tools Target Platform</description>
			</category-def>

			<xsl:apply-templates select="//unit" />
			<xsl:apply-templates select="//feature" />
		</site>
	</xsl:template>

	<xsl:template match="//unit">
		<xsl:choose>
			<xsl:when test="substring-before(@id,'.feature.group')!=''">
				<xsl:choose>
					<xsl:when test="$useLatest='true'">
						<feature
							url="features/{substring-before(@id,'.feature.group')}_0.0.0.jar"
							id="{substring-before(@id,'.feature.group')}" version="0.0.0">
							<category name="TargetPlatform" />
						</feature>
					</xsl:when>
					<xsl:otherwise>
						<feature
							url="features/{substring-before(@id,'.feature.group')}_{@version}.jar"
							id="{substring-before(@id,'.feature.group')}" version="{@version}">
							<category name="TargetPlatform" />
						</feature>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="$useLatest='true'">
						<bundle url="plugins/{@id}_0.0.0.jar" id="{@id}"
							version="0.0.0">
							<category name="TargetPlatform" />
						</bundle>
					</xsl:when>
					<xsl:otherwise>
						<bundle url="plugins/{@id}_{@version}.jar" id="{@id}"
							version="{@version}">
							<category name="TargetPlatform" />
						</bundle>
					</xsl:otherwise>
				</xsl:choose>

			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template match="//feature">
		<feature url="features/{@id}_0.0.0.jar" id="{@id}" version="0.0.0">
			<category name="TargetPlatform" />
		</feature>
	</xsl:template>

	<!-- ignore anything else -->
	<xsl:template
		match="environment|targetJRE|launcherArgs|includeBundles|location|locations" />

</xsl:stylesheet>