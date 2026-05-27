<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">

    <html>
      <head>
        <link rel="stylesheet" href="EstadisticasEstilos.css"></link>
      </head>
      <body>

        <h1>
          ESTADISTICAS NINIS VS COSAS
        </h1>

        <table cellspacing="3" style="background-color: #f0f0f0;">

          <caption>Ranking</caption>

          <thead>
            <tr>
              <th id="apartados"> TOP</th>
              <th id="apartados">NOMBRE</th>
              <th id="apartados">PUNTUACION</th>
              <th id="apartados">TIEMPO JUGADO</th>
              <th id="apartados">FECHA</th>
            </tr>
          </thead>
          <tbody id="ranking-body">

          </tbody>
        </table>

        <script>
        var players = [
        <xsl:for-each select="jugadores/jugador">
            <xsl:sort select="puntuaciónTotal" data-type="number" order="descending" /> { 
              nombre: "<xsl:value-of select="nombre" />", 
              punt: <xsl:value-of select="puntuaciónTotal" />, 
              dia: "<xsl:value-of select="fecha/dia" />", 
              mes: "<xsl:value-of select="fecha/mes" />", 
              año: "<xsl:value-of select="fecha/año" />", 
              h: <xsl:value-of select="tiempoJugado/horas" />, 
              m: <xsl:value-of select="tiempoJugado/minutos" />, 
              s: <xsl:value-of select="tiempoJugado/segundos" />,
              cosasMatadas: <xsl:value-of select="cosasMatadas" />, 
              ninisMuertos: <xsl:value-of select="ninisMuertos" />, 
              ninisEliminados: <xsl:value-of select="ninisEliminados" />,
              butanitos: <xsl:value-of select="butanitosTotales" />, 
              ninis: [ <xsl:for-each select="ninisJugados/nini">
                <xsl:sort select="nombre" data-type="string" order="descending" /> { 
                  nombre: "<xsl:value-of select="nombre" />",
                  imagen: "<xsl:value-of select="@imagen" />",
                  descripcion: "<xsl:value-of select="descripcion" />",
                  coste: "<xsl:value-of select="coste" />",
                  vida: "<xsl:value-of select="vida" />",
                  alcance: "<xsl:value-of select="alcanceAtaque" />",
                  radio: "<xsl:value-of select="radioAtaque" />",
                  proyectil: "<xsl:value-of select="tipoProyectil" />",
                  daño: "<xsl:value-of select="daño" />" }
                  
            <xsl:if test="position() != last()">,</xsl:if>
          </xsl:for-each>],
          logros: [ 
            <xsl:for-each select="logros/logro"> {
              id: "<xsl:value-of select="@idLogro" />",
              completado: "<xsl:value-of select="@completado" />",
              titulo: "<xsl:value-of select="titulo" />",
              minuto: "<xsl:value-of select="minuto" />",
              tipoMedalla: "<xsl:value-of select="medallita/tipoMedalla" />",
              puntuacionLogro: "<xsl:value-of select="medallita/puntuacionLogro" />" }

              <xsl:if test="position() != last()">,</xsl:if>
            </xsl:for-each>] }

            <xsl:if test="position() != last()">,</xsl:if>
            </xsl:for-each>];
          </script>
        <script src="OcultarContenidoTablas.js" />
      </body>

    </html>

  </xsl:template>

</xsl:stylesheet>