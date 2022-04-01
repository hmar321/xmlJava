<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="mitabla"
					page-height="7in" page-width="12in" margin-top="1cm"
					margin-bottom="1cm" margin-left="9.5cm">
					<fo:region-body margin-top="1cm" />
					<fo:region-before extent="0.5cm" />
					<fo:region-after extent="0.5cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="mitabla">
				<fo:static-content flow-name="xsl-region-after"
					text-align="right" margin-right="1cm">
					<fo:block background-color="yellow">Actividad 6.5 de Héctor Almaraz
						página 1</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="16pt">
						Lista de ciudades de Héctor Almaraz
					</fo:block>
					<fo:table border="1px solid black" table-layout="fixed">
						<fo:table-column column-width="50mm" />
						<fo:table-column column-width="50mm" />
						<fo:table-header>
							<fo:table-row background-color="green">
								<fo:table-cell>
									<fo:block font-weight="bold" text-align="center">ciudad
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-weight="bold" text-align="center">habitantes
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-header>
						<fo:table-body border="1px solid black">
							<xsl:for-each select="ciudades/ciudad">
								<fo:table-row>
									<fo:table-cell border="1px solid black">
										<fo:block text-align="center">
											<xsl:value-of select="nombre" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border="1px solid black">
										<fo:block text-align="center">
											<xsl:value-of select="habitantes" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</xsl:for-each>
						</fo:table-body>
					</fo:table>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>
