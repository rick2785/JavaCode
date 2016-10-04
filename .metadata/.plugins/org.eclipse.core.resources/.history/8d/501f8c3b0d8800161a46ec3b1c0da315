<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" />

	<!-- xsl:template is used to define rules for everything in the root node -->
	<!-- The rules defined in the template can be applied to the element in
	match as well as all of its child elements or nodes -->

	<xsl:template match="/">
		
		<!-- apply-templates applies a template to the element matched
		and its child nodes -->
		
		<xsl:apply-templates select="tvshow/show" />
		
	</xsl:template>
	
	<xsl:template match="show">
  		<xsl:apply-templates select="name"/> 
  		
  		<!-- Get position versus other nodes -->
  		
  		Node Position: <xsl:value-of select="position()" /> out of 
  		<xsl:value-of select="last()" /> nodes <br />
  		
  		Ratings: Averaged <xsl:value-of select="viewers"/> million viewers 
  		versus the average of the rest 
  		
  		<!-- format-number(number to format, how to show number
  		# - show when nt zero and 0 - always show a number and 
  		where you want commas and decimals-->
  		
  		<!-- sum() sums every element that matches -->
  		
  		<!-- div is used for division -->
  		
  		<!-- count() returns the number of elements that match -->
  		
  		<xsl:value-of select="format-number(sum(/tvshow/show/viewers)
  		div count(/tvshow/show), '#,##0.000')"/> million<br />
  		
  		<!-- More functions for rounding -->
  		
  		3.14 Rounded <xsl:value-of select="round(3.14)"/><br />
  		
  		3.14 Ceiling <xsl:value-of select="ceiling(3.14)"/><br />
  		
  		3.14 Floor <xsl:value-of select="floor(3.14)"/><br />
  		
  		<!-- Extract the first name of an actor using substring-before() -->
  		<!-- I could get the last name with substring-after() -->
  		
  		<xsl:for-each select="actors/actor">
			
			<xsl:value-of select="substring-before(real_name, ' ')"/> and 
			
		</xsl:for-each> are good actors.<br />
		
		Is I in Team: <xsl:value-of select="contains('Team', 'I')" /><br />
  		
  		<br />
  		
  		<!-- Call the template for the character -->
  		
  		<xsl:apply-templates select="actors/actor/character"/>
  		
	</xsl:template>
	
	<xsl:template match="name">
		
		<div style="float:left">
		
			<img>
				<xsl:attribute name="src">
						<xsl:value-of select="../poster/@href" />
				</xsl:attribute>
			</img>
		
		</div><br />
	
		<span style="color:#000; font-size: 14pt">
		
			<!-- . is a reference to the current node being name -->
			<!-- translate() can be used to capitalize letters -->
			
			<xsl:value-of select="translate(.,
			'abcdefghijklmnopqrstuvwxyz', 
			'ABCDEFGHIJKLMNOPQRSTUVWXYZ')"/>
			
			<!-- To reference a sibling of the name node use ../ -->
			
			was released in <xsl:value-of select="../release"/>.
			
			<!-- This is how you can grab other child nodes and attributes -->
			
			The Star <xsl:value-of select="../actors/actor/character"/> was played by 
			<xsl:value-of select="../actors/actor/character/@profession"/> 
			<xsl:text> </xsl:text><xsl:value-of select="../actors/actor/real_name"/>
		
		</span><br /><br />
		
		<span>
		
		Release: <xsl:value-of select="../release"/><br />
		Cancelled: <xsl:value-of select="../end_date"/><br />
		Description: <xsl:value-of select="../description"/><br />
		Average Viewers: <xsl:value-of select="../viewers"/>

		<!-- You can use xsl:text to insert text. It can also be used to
		make spaces between tags which wouldn't be printed otherwise -->
		
		<xsl:text> </xsl:text><xsl:value-of select="../viewers/@units"/><br /><br />
		
		Stars<br />
		<ul>
		
		<xsl:for-each select="../actors/actor">
			
				<li><xsl:value-of select="character"/> played by 
				<xsl:value-of select="real_name"/></li>
			
		</xsl:for-each>
		
		</ul>
		
		</span>
		
		<br /><br />
  		
	</xsl:template>
	
	<!-- Only making a change based on a condition -->
		
	<xsl:template match="actors/actor/character[@profession='Detective']">
	
		<!-- You can define styles this way but it is better to use external files -->
		
		Found Detective<br />
		
		<span style="color:#0000ff; font-size: 14pt">
		
			<!-- . is a reference to the current node being name -->
			
			<xsl:value-of select="."/><br />
		
		</span>
	
	</xsl:template>
	
	<xsl:template match="actors/actor/character[@profession!='Detective']">
	
		<!-- You can define styles this way but it is better to use external files -->
		
		<span style="color:#fff; font-size: 14pt">
		
			<!-- . is a reference to the current node being name -->
			
			<xsl:value-of select="."/><br />
		
		</span>
	
	</xsl:template>
	
</xsl:stylesheet>