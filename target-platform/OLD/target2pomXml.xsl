<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="xml" indent="yes" encoding="UTF-8"
		version="1.0" />
	<xsl:decimal-format decimal-separator="."
		grouping-separator="," />

	<xsl:param name="useLatest" select="'true'" />

	<xsl:variable name="platformFilter"
		select="concat(/target/environment/os/text(), ',', /target/environment/ws/text(), ',', /target/environment/arch/text())" />

	<xsl:template match="target">
		<project
			xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
			xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
			<modelVersion>4.0.0</modelVersion>
			<parent>
				<groupId>org.jboss.tools</groupId>
				<artifactId>org.jboss.tools.parent.pom</artifactId>
				<version>0.0.1-SNAPSHOT</version>
			</parent>
			<groupId>org.jboss.tools</groupId>
			<artifactId>org.jboss.tools.target.platform.site</artifactId>
			<name>JBoss Tools Target Platform Definition Site</name>
			<version>0.0.1-SNAPSHOT</version>
			<packaging>eclipse-update-site</packaging>

			<profiles>
				<profile>
					<id>targetPlatformRepositories</id>
					<activation>
						<activeByDefault>true</activeByDefault>
					</activation>
					<repositories>
						<xsl:apply-templates select="//repository" />
					</repositories>
				</profile>
			</profiles>
		</project>
	</xsl:template>

	<xsl:template match="//repository">
		<repository>
			<id>
				<xsl:variable name="myString" select="@id" />
				<xsl:variable name="myNewString">
					<xsl:call-template name="replaceCharsInString">
						<xsl:with-param name="stringIn"
							select="substring-after(@location, '//')" />
						<xsl:with-param name="charsIn" select="'/'" />
						<xsl:with-param name="charsOut" select="'_'" />
					</xsl:call-template>
				</xsl:variable>
				<xsl:value-of select="$myNewString" />
			</id>
			<url>
				<xsl:value-of select="@location" />
			</url>
			<layout>p2</layout>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
			<releases>
				<enabled>true</enabled>
			</releases>
		</repository>
	</xsl:template>

	<!-- ignore anything else -->
	<xsl:template
		match="environment|targetJRE|launcherArgs|includeBundles|location|locations|unit|feature" />

	<!-- pretend this is in a template -->

	<!-- here is the template that does the replacement -->
	<xsl:template name="replaceCharsInString">
		<xsl:param name="stringIn" />
		<xsl:param name="charsIn" />
		<xsl:param name="charsOut" />
		<xsl:choose>
			<xsl:when test="contains($stringIn,$charsIn)">
				<xsl:value-of
					select="concat(substring-before($stringIn,$charsIn),$charsOut)" />
				<xsl:call-template name="replaceCharsInString">
					<xsl:with-param name="stringIn"
						select="substring-after($stringIn,$charsIn)" />
					<xsl:with-param name="charsIn" select="$charsIn" />
					<xsl:with-param name="charsOut" select="$charsOut" />
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$stringIn" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

</xsl:stylesheet>