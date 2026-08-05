

## smooks-editor

[**Descargar p2-repository**][download-site]

Editor gráfico de Smooks basado en Eclipse (Indigo)
Este es un fork del [repositorio de jboss tools][jboss-smooks-editor].

## Compilación

Por el momento, solo se puede compilar desde Eclipse.

 - Descargar Eclipse Indigo
 - Instalar m2e
 - Importar el proyecto
 - Importar la configuración de destino **indigo-target** desde el directorio target-platform
 - Importar los plugins
 - Importar las features
 - Abrir site.xml desde el directorio **site**
 - Hacer clic en build all
 - El sitio se generará en el directorio **site**
 - Abrir Help -> Install new Software -> click add -> local -> navegar al directorio site anterior -> install all
 - Listo

## Objetivos

 - Hacer que se compile únicamente con Maven
 - Agregar smooks 1.5
 - Corregir tests
 - Portar a Eclipse 4.x (tal vez con una capa de compatibilidad)

## Recursos

 - [Guía HTML aquí][html-guide]
 - [Tutorial en video aquí][video-guide]


[jboss-smooks-editor]: https://github.com/jbosstools/jbosstools-full-svn-mirror/tree/3.3.indigo/smooks "Smooks Editor"
[html-guide]: http://docs.jboss.org/tools/OLD/3.1.0.GA/en/jboss_smooks_plugin_ref_guide/html_single/index.html "Html guide"
[video-guide]: http://www.smooks.org/mediawiki/index.php?title=Eclipse_IDE "Video guide"
[download-site]: https://github.com/alexproca/smooks-editor/releases/download/working-eclipse/site.zip "P2 Site"
