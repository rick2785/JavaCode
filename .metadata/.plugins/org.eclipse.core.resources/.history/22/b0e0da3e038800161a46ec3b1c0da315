<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- XSLT: eXtensible Style Language Used for styling XML -->
	
	<!-- This sets the output type (Not Needed for HTML) -->
	
	<xsl:output method="html" />
	
	<!-- xsl:template : States that we want to match the whole document -->
	<!-- All of the rules that follow will apply to the root node -->
	
	<xsl:template match="/">
		
		<html>
			<head><title>TV Shows</title></head>
			<body>
				<!-- Return the XSLT Version used -->
				
				Version: <xsl:value-of select="system-property('xsl:version')" /><br />
				
				<!-- Return the XSLT Vendor used -->
				<!-- libxml2 : Toolkit developed for the Gnome project -->
				
				Vendor: <xsl:value-of select="system-property('xsl:vendor')" /><br />
				
				Vendor URL: <xsl:value-of select="system-property('xsl:vendor-url')" /><br />
				
				<!-- Cycles through each node in the XML file -->
				
				<xsl:for-each select="tvshow/show">
				
					<!-- generate-id() returns a unique node identifier -->
					
					<a href="#{generate-id(name)}">
					
					<!-- Get the value of name for the node -->
					
					<xsl:value-of select="name" /></a><br />
				</xsl:for-each>
				
				<br />
			
				<!-- Cycles through each node in the XML file -->
				
				<xsl:for-each select="tvshow/show">
				
					<!-- xsl:sort sorts based on your rules 
						select: node to base sort on
						order: ascending (default) or descending
						data-type: text or number	-->
				
					<xsl:sort select="name" order="ascending" data-type="text" />
				
					<!-- Print show name with a link to the list above -->
				
					<h3><a name="{generate-id(name)}">
					<xsl:value-of select="name" /></a></h3>
				
					<!-- Here I create an img tag and add attributes to it -->
				
					<img> 
					
						<!-- Select the attribute to change -->
						
						<xsl:attribute name="src"> 
						
						<!-- Set the value for the attribute -->
						<!-- You grab the attribute of a node with @ -->
						
						<xsl:value-of select="poster/@href" /> 
						</xsl:attribute> 
					</img><br />
				
					<!-- Returns the current node information -->
					
					<xsl:value-of select="current()"/>
					
					<p>The show <xsl:value-of select="name"/> was released in
					<xsl:value-of select="release"/> by 
					<xsl:value-of select="network"/>. It had an average 
					viewership of <xsl:value-of select="viewers"/> million people.
					It was cancelled in <xsl:value-of select="end_date"/>
					</p><br />
				
				</xsl:for-each>
				
				<!-- Output Information in a table -->
				
				<table border="2">
				<tr><th>Name</th><th>Network</th><th>Viewers</th></tr>
				<xsl:for-each select="tvshow/show">
				
				<!-- Checks if the attribute of network is not equal to UK -->
				
				<!-- This will only allow non-UK shows on the list -->
				
				<!-- You can use: = != > &lt; -->
				
				<!-- <xsl:if test="network[@country='UK']"> -->
				
				<!-- Shows results when release < 2006 -->
				
				<xsl:if test="release &lt; 2006">
				
				<tr>
					<td><xsl:value-of select="name"/></td>
					<td><xsl:value-of select="network"/></td>
					<td><xsl:value-of select="viewers"/></td>
				</tr>
				
				</xsl:if>
				
				<!-- xsl:choose is used to cover many conditions -->
				
				<xsl:choose>
				
					<!-- xsl:when defines under what condition to execute -->
				
					<xsl:when test="release > 2006">
					
						<tr bgcolor="yellow">
							<td><xsl:value-of select="name"/></td>
							<td><xsl:value-of select="network"/></td>
							<td><xsl:value-of select="viewers"/></td>
						</tr>
					
					</xsl:when>
					
					<xsl:when test="release = 2006">
					
						<tr bgcolor="orange">
							<td><xsl:value-of select="name"/></td>
							<td><xsl:value-of select="network"/></td>
							<td><xsl:value-of select="viewers"/></td>
						</tr>
					
					</xsl:when>
					
					<!-- If xsl:if was removed this would be the default action for xsl:choose  -->
					
					<xsl:otherwise>
					
						<tr bgcolor="pink">
							<td><xsl:value-of select="name"/></td>
							<td><xsl:value-of select="network"/></td>
							<td><xsl:value-of select="viewers"/></td>
						</tr>
					
					</xsl:otherwise>
				
				</xsl:choose>
				
				</xsl:for-each>
				</table>
				
			</body>
		</html>

	</xsl:template>
	
</xsl:stylesheet>