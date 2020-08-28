# TestElClimaRGA

Buenas tardes, 

1.- La aplicación fue realizada como dice el enunciado en la plataforma Android SDK 22 en Lenguaje de Programación Java.
    No pude configurar en un archivo por separado el API KEY, por lo que hay que hacerlo 5 veces, una vez por cada ciudad.
    Además del mainactivity, hay cinco actividades con sus respectivos layouts, estas actividades son:
    asuncion.java, ciudadDelEste.java, encarnacion.java, lomaPlata.java, villaRica.java.
    
    En la línea 46 de cada actividad, hay que agregar la api key personal: 
       .url("https://api.openweathermap.org/data/2.5/weather?id=3436714&appid= ACA VA LA API KEY PERSONAL &units=metric")
       
2.- La aplicación cumple con los requisitos básicos que pueden ser probados:
    1.- En la pantalla principal está el listado de cinco ciudades del enunciado.
    2.- Al elegir/pulsar una de las ciudades, direcciona la actividad de esa ciudad, donde se puede visualizar los datos obtenidos de openweather.
    
3.- El principal problema que tuve fue poder no separar en otro archivo la conexión al API de openweather, por lo que se realiza una vez en cada actividad.
