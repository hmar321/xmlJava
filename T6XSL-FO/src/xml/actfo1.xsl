<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master
					master-name="A4-portrait" page-height="9.0cm" page-width="20.0cm"
					margin="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="A4-portrait">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						Nos hace mucha ilusión compartir con vosotros este día
						tan especial.
					</fo:block>
					<xsl:for-each select="invitados/invitado">
						<fo:block>
							<xsl:value-of select="nombre" />
						</fo:block>
					</xsl:for-each>
					<fo:block>
						La ceremonia empezará a las 16:00 pm.
						En la iglesia X.
						Se celebrará en nuestra casa.
						Teléfono de confirmación 123456789.
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>