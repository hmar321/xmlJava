<?xml version="1.0" encoding="utf-8"?>
<fo: root xmlns: fo="http://www.w3.org/1999/XSL/Format">
	<fo:layout-master-set>
		<!-- Tamaño y configuración de la página -->
		<fo:simple-page-master
			master-name="tarjeta-presentacion" page height="5.5cm"
			page-width="8.5cm" margin-top="2.2cm" margin-bottom="0.5cm">
			<fo: region-body />
			<fo: region-before extent="0.5cm" />
			<fo: region-after extent="0.5cm" />
		</fo:simple-page-master>
	</fo:layout-master-set>
	<!-- Página -->
	<fo: page-sequence master-reference="tarjeta-presentacion">
		<fo: flow flow-name="xsl-region-body">
			<!-- Nombre de la persona. Tamaño de la fuente 16 puntos. -->
			<fo:block font-size="16pt" text-align="center">
				Fernando Paniagua
			</fo:block>
			<!-- Profesión de la persona. Tamaño de la fuente 8 puntos. Color # 88888 
				(gris) -->
			<fo:block font-size="8pt " text-align="center"
				color="#888888">
				Programador
			</fo:block>
		</fo: flow>
	</fo: page-sequence>
</fo: root>

