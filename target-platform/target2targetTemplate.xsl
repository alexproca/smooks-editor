<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<!-- 
	This XSLT is used by targetUpdateFromRepo.xml to update the versions on IUs in a .target file
	CAUTION: do not auto-format this file or line breaks will appear where they should not be!
-->

<xsl:param name="replacement.URL"/>
<xsl:param name="replace.versions"/>

<!-- Copy unit nodes and optionally (if we ran contentXml2artifactVersions.xsl transform and have artifactVersions.properties file) templatize their version attributes -->
<xsl:template match="unit">
<xsl:choose>
<xsl:when test="$replace.versions">
<unit id="{@id}" version="${{{@id}.version}}">
<xsl:apply-templates/>
</unit>
</xsl:when>
<xsl:otherwise>
<unit id="{@id}" version="{@version}">
<xsl:apply-templates/>
</unit>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<!-- Copy repository nodes and optionally replace their location attributes (if replacement.URL is set) -->
<xsl:template match="repository">
<xsl:choose>
<xsl:when test="$replacement.URL">
<repository location="{$replacement.URL}">
<xsl:apply-templates/>
</repository>
</xsl:when>
<xsl:otherwise>
<repository location="{@location}">
<xsl:apply-templates/>
</repository>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<!-- Copy everything else unchanged -->
<xsl:template match="@*|node()">
<xsl:copy>
<xsl:apply-templates select="@*|node()"/>
</xsl:copy>
</xsl:template>

</xsl:stylesheet>
