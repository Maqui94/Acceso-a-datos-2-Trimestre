<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                  rel="stylesheet"
                  integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                  crossorigin="anonymous"/>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"/>
            <link
                    rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
            />
            <title> Peliculas Cartelera</title>

        </head>
        <body>
            <div class="container">
            <h1 class="animate__animated animate__bounce">Transformación de peliculas</h1>
                


                 <h2>Transformaciones via XSL -->For Each</h2>
            <div class="row">
            <xsl:for-each select="peliculas/pelicula">
                <div class="col">
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" alt="...">
                            <xsl:attribute name="src">
                                <xsl:value-of select="@poster"/>
                            </xsl:attribute>
                        </img>

                    <div class="card-body">
                        <h5 class="card-title">
                            <xsl:value-of select="@titulo"/>
                        </h5>
                        <p class="card-text">
                            <xsl:value-of select="sinopsis"/>
                        </p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
                </div>
            </xsl:for-each>
        </div>






        <!--    <ul class="list-group-" >

             <xsl:for-each select="peliculas/pelicula">
                 <li class="list-group-item animate__animated animate__bounce">
                 <xsl:attribute name="style">
                     <xsl:choose>
                         <xsl:when test="@genero='Acción'">
                             background-color:#ff0000;
                             font-size:10px
                         </xsl:when>
                         <xsl:when test="@genero='Crimen'">
                             background-color:#ffa500;
                             font-size:18px
                         </xsl:when>
                         <xsl:when test="@genero='Drama'">
                             background-color:#3cb371;
                             font-size:16px
                         </xsl:when>
                         <xsl:when test="@genero='Western'">
                             background-color:#6a5acd;
                             font-size:12px
                         </xsl:when>
                      </xsl:choose>
                      </xsl:attribute>
                         <xsl:if test="@puntuacion>3">

                     <xsl:value-of select="@titulo"/>
                         </xsl:if>
                 </li>

             </xsl:for-each>
         </ul> -->
            </div>

        </body>
    </html>
</xsl:template>
</xsl:stylesheet>