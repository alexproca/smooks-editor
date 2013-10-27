<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<!-- 
	This XSLT is used by targetUpdateFromRepo.xml to update the versions on IUs in a .target file
	CAUTION: do not auto-format this file or line breaks will appear where they should not be!
-->
<xsl:output method="text" indent="no" encoding="UTF-8" version="1.0" />
<xsl:template match="repository">
<xsl:apply-templates select="//unit" />
</xsl:template>
<xsl:template match="//unit"><xsl:value-of select="@id" />.version=<xsl:value-of select="@version" />
#
</xsl:template>
</xsl:stylesheet>
