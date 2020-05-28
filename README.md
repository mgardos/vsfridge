# Heladera Inteligente Virtual

## Contenidos
+ [Descripcion de la propuesta](#descripcion-de-la-propuesta)
+ [Diagrama esquematico](#diagrama-esquematico)
+ [Caracteristicas de heladeras inteligentes](#caracteristicas-de-heladeras-inteligentes)
+ [Cuadro de capacidades de heladeras inteligentes](#cuadro-de-capacidades-de-heladeras-inteligentes)
+ [Usos de la heladera inteligente](#usos-de-la-heladera-inteligente)
+ [Diagrama de casos de uso](#diagrama-de-casos-de-uso)
+ [Descripcion de casos de uso](#descripcion-de-casos-de-uso)
  + [Caso de uso Encender CU_ED](#caso-de-uso-encender-cu_ed)
  + [Caso de uso Abrir CU_AR](#caso-de-uso-abrir-cu_ar)
  + [Caso de uso Poner producto CU_PP](#caso-de-uso-poner-producto-cu_pp)
  + [Caso de uso Tomar producto CU_TP](#caso-de-uso-tomar-producto-cu_tp)
  + [Caso de uso Identificar productos CU_IP](#caso-de-uso-identificar-productos-cu_ip)
  + [Caso de uso Cerrar CU_CR](#caso-de-uso-cerrar-cu_cr)
  + [Caso de uso Identificar productos manualmente CU_IM](#caso-de-uso-identificar-productos-manualmente-cu_im)
  + [Caso de uso Comprar alimentos CU_CA](#caso-de-uso-comprar-alimentos-cu_ca)
  + [Caso de uso Monitoreae vencimiento de alimentos CU_MV](#caso-de-uso-monitorear-vencimiento-de-alimentos-cu_mv)
  + [Caso de uso Notificar alimentos en vencimiento CU_NV](#caso-de-uso-notificar-alimentos-en-vencimiento-cu_nv)
  + [Caso de uso Monitorear escasez de alimentos CU_ME](#caso-de-uso-monitorear-escasez-de-alimentos-cu_me)
  + [Caso de uso Notificar escasez de alimentos CU_NE](#caso-de-uso-notificar-escasez-de-alimentos-cu_ne)
+ [Mockups](#mockups)
+ [Diagramas del modelo de dominio](#diagramas-del-modelo-de-dominio)
+ [Diagramas de secuencia](#diagramas-de-secuencia)
  + [Flujos normal y alternativo para Encender](#flujos-normal-y-alternativo-para-encender)
  + [Flujo normal para Abrir](#flujo-normal-para-abrir)
  + [Flujos alternativos para Abrir](#flujos-alternativos-para-abrir)
+ [Diagramas de actividad](#diagramas-de-actividad)

## Descripcion de la propuesta

Algunas de las grandes compañías de electrónica y electrodomésticos han comenzado a dar los primeros pequeños pasos en la dirección de lo que podría llegar a considerarse la heladera inteligente. En algunos países desarrollados e industrializados se comercializan en la actualidad  heladeras publicitadas como inteligentes. Aquello que se considera inteligente puede variar drásticamente dependiendo de diversos factores, como el sujeto, el objeto, el contexto, la escala, las expectativas, en otros. La heladera que este trabajo práctico considera inteligente se encuentra descrita mediante los usos que se espera hacer de ella, enunciados en la sección Usos de la heladera inteligente.

El diagrama esquematico presenta el entorno en el cual opera la heladera inteligente. Los actores principales que se observan en el diagrama son la heladera inteligente y el consumidor, que hace uso de ella. Otros actores o participantes, que se consideran secundarios, son otras heladeras inteligentes vecinas o próximas, proveedores de alimentos o productos alimenticios, tales como supermercados, tiendas en línea o fuera de línea, y despachantes de productos, ya sea propios de los proveedores mencionados o independientes.

## Diagrama esquematico

![schematic diagam](https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/schematic_diagram.svg)

### Heladera inteligente

Equipo que ademas de conservar alimentos, ofrece un conjunto de facilidades que brindan al usuario o consumidor la posibilidad de aprovechar mas y mejor los alimentos. Este dispositivo es responsable de los alimentos en su interior y se encarga de identificar las costumbres alimentarias de consumidor, facilitando la administracion de dichos alimentos. Mantiene una comunicacion bidireccional con el consumidor, brindando informacion sobre su estado y de los alimentos que contiene, asi como tambien dispone de la capacidad para comunicarse con otros dispositivos inteligentes y sistemas de informacion mediante apis estandar.

### Consumidor

El usuario o consumidor es quien hace uso de la heladera inteligente, deposita y retira alimentos, consulta el estado y disponibilidad de los mismos sin necesidad de acercarse a la heladera, configura alertas relativas a los alimentos, entre otras acciones, y acepta las sugerencias de la heladera relativas a la administracion de alimentos.

## Caracteristicas de heladeras inteligentes

### Caracteristicas comunes de heladeras inteligentes en el mercado

1. Acceso a Internet y conectividad con otros dispositivos inteligentes mediante WiFi.
2. Comando por voz para control de funciones básicas (ajuste de temperatura, fabricación de hielo, etc.) mediante Amazon Alexa o Google Assistant.
3. Descarga de aplicaciones para mayor control de funciones básicas.
4. Alertas en teléfono móvil por puerta abierta, incremento o disminución de la temperatura en el interior.
5. Creación de lista de alimentos necesarios y sincronizarlo con teléfono móvil.
6. Configurar fechas de vencimiento y recibir alertas en teléfono móvil.
7. Creación de perfiles para usuarios de la heladera (por ejemplo, miembros de la familia), que permite crear y compartir mensajes y listas de tareas.

### Caracteristicas especificas de heladeras inteligentes en el mercado

1. Dispenser de agua caliente.
2. Dispenser de café y té.
3. Ayuda en línea.
4. Vista del interior sin apertura de puertas y/o pérdida de frío.
5. Pantalla táctil extra grande.
6. Observar en forma remota desde el teléfono móvil los productos en el interior.
7. Transmitir audio y/o video a un televisor inteligente.

## Cuadro de capacidades de heladeras inteligentes

El siguiente cuadro especifica las caractiristicas inteligentes de heladeras comercializadas por los fabricates indicados. El grado de inteligencia correspondiente a cada caracteristica varia entre fabricantes.

|                                                 | Samsung | LG      | Hitachi | Panasonic | Sharp | Bosch | Siemens | Virtual |
| ------------------------------------------------|:-------:|:-------:|:-------:|:---------:|:-----:|:-----:|:-------:|:-------:|
| Conectar a red WiFi                             | Si      | Si      | Si      |           | No    | Si    | Si      | N/A     |
| Control por aplicación móvil                    | Si      | Si      | Si      |           | No    | Si    | Si      | N/A        |
| Detectar heladera apagada                       | Si      | Si      | Si      | No        | No    | Si    | Si      | N/A     |
| Control por panel en puerta                     | Si      | Si      | No      | No        | Si    | No    | No      | N/A      |
| Instalar aplicaciones                           | Si      |         |         |           | No    | No    | No      | N/A        |
| Comando por voz                                 | Si      | Si      |         |           | No    |       |         | N/A        |
| Apertura de puerta tactil                       | No      | No      | Si      | Si        |       |       |         | N/A     |
| Acceder a sitios en Internet                    | Si      |         |         |           | No    | No    | No      | N/A        |
| Espejar telefono movil                          | Si      |         |         |           | No    |       |         | N/A        |
| Detectar y notificar puerta abierta             | Si      | Si      | Si      | Si        | Si    | Si    | Si      | Si      |
| Sensar tiempo de puerta abierta                 |         |         |         | Si        | No    |       |         | Si      |
| Sensar numero de aperturas de puerta            |         |         | Si      |           | No    |       |         | Si      |
| Ajustar temperatura                             |         | Si      | Si      |           | Si    | Si    | Si      | N/A        |
| Detectar y notificar cambio de temperatura      | No      | No      | No      | No        | No    | Si    | Si      | N/A      |
| Ajustar humedad                                 | Si      |         |         |           |       |       |         | N/A        |
| Ajustar filtro de aire                          |         |         |         |           |       |       |         | N/A        |
| Activar hielo adicional                         |         |         |         |           |       |       |         | N/A        |
| Ajustar ahorro de energia                       | Si      |         | Si      |           | Si    |       |         | N/A        |
| Visualizar consumo de energia                   |         |         |         |           |       |       |         | N/A        |
| Crear perfil del usuario                        | Si      |         |         |           | No    |       |         | Si        |
| Enviar mensajes a otros usuarios                | Si      |         |         |           | No    |       |         | N/A        |
| Enviar lista de tareas a otros usuarios         |         |         |         |           | No    |       |         | N/A        |
| Crear agenda de actividades para usuario        | Si      |         |         |           | No    |       |         | N/A     |
| Crear mensajes y dibujos en la puerta           | Si      |         |         |           | No    | No    | No      | N/A        |
| Mostrar fotos en la puerta                      | Si      |         |         |           | No    | No    | No      | N/A        |
| Reproducir video en la puerta                   | Si      |         |         |           | No    | No    | No      | N/A        |
| Espejar televisor inteligente                   | Si      |         |         |           | No    | No    | No      | N/A        |
| Reproducir musica desde la puerta               | Si      |         |         |           | No    | No    | No      | N/A        |
| Transmitir musica a dispositivos compatibles    | Si      |         |         |           | No    | No    | No      | N/A        |
| Planificar comida con alimentos en el interior  |         |         |         |           | No    | No    | No      | N/A        |
| Crear lista de compras                          | Si      |         | Si      |           |       |       |         | Si      |
| Ver alimentos en el interior a puerta cerrada   | Si      |         |         |           |       | Si    |         | Si      |
| Sugerir ubicacion de alimentos                  | No      | No      | No      | No        | No    | Si    | No      | N/A      |
| Definir alarma para compra de alimentos         | No      | No      | No      | No        | No    | No    | No      | Si      |
| Leer recetas al usuario                         | Si      |         |         |           | No    | No    | No      | N/A        |
| Tomar dictado del usuario                       |         |         |         |           | No    | No    | No      | N/A        |
| Realizar compra de alimentos manual             | Si      | No      | No      | No        | No    | No    | No      | Si      |
| Comprar alimentos escazos sin asistencia manual | No      | No      | No      | No        | No    | No    | No      | Si      |
| Controlar otros dispositivos inteligentes       | Si      | No      | No      | No        | No    | No    | No      | N/A        |
| Encender luz inteligente                        | Si      | No      | No      | No        | No    | No    | No      | N/A        |
| Atender portero inteligente                     | Si      | No      | No      | No        | No    | No    | No      | N/A        |
| Recibir notificacion de lavaropas inteligente   | Si      |         |         |           |       |       |         | N/A        |
| Administrar lista de alimentos en interior      | Si      |         | Si      |           |       |       |         | Si      |
| Detectar e identificar alimentos en el interior | No      | No      | No      | No        | No    | No    | No      | Si      |
| Detectar cantidad de alimentos                  | No      | No      | No      | No        | No    | No    | No      | Si      |
| Monitorear vencimiento de alimentos             | No      | No      | No      | No        | No    | No    | No      | Si      |
| Administrar compra de alimentos segun consumo   | No      | No      | No      | No        | No    | No    | No      | Si      |

La seccion de referencias incluye vinculos a los modelos de las marcas mencionadas en el cuadro de capacidades. 

### Detectar e identificar alimentos en el interior

La heladera es capaz de detectar alimentos ingresados en su interior, identificar el alimento de que se trata, o solicitar asistencia al usuario para lograrlo y aprender de eso. La heladera dispone de camaras que capturan imagenes de los alimentos una vez cerrada la puerta, para luego procesarlas mediante una red neuronal que identifica los alimentos.

### Detectar cantidad de alimentos

La heladera es capaz de aproximar la cantidad de cada alimento en su interior ya que puede identificarlos, sensar el peso de cada estante y la estimar del volumen de cada alimento. Esto permite a la heladera informar al consumidor los alimentos escasos, y establecer patrones de consumo.

### Monitorear vencimiento de alimentos

Como parte de la identificacion de alimentos en su interior, la heladera tambien detecta fechas de vencimiento impresas en en envases, envoltorios o los mismos productos (como es el caso de huevos que en ocasiones disponen de la fecha de vencimiento en la cascara). En caso de ser necesario, la heladera solicita confirmar o ingresar al consumidor la fecha de vencimiento de un alimento. Esto permite a la heladera informar al consumidor los alimentos proximos a vencer.

### Administrar compra de alimentos segun consumo

En base al monitoreo de cantidad de alimentos, consumo y vencimientos de los mismos, la heladera prepara el listado de alimentos que sugiere al consumidor adquirir y procede con la compra en caso que el consumidor lo decida.

### Comprar alimentos escazos sin asistencia manual

Para efectuar la compra de alimentos la heladera establecera comunicacion con aquellos proveedores de los mismos preferidos por el consumidor. Para esto, el consumidor previamente informa a la heladera sobre los proveedores de los cuales espara recibir alimentos. La heladera gestiona la compra manteniendo informado al consumidor respecto a stock, costos y plazos de entrega.

## Usos de la heladera inteligente

1. Detectar productos y fechas de vencimiento al ser introducidos en su interior.
2. Informar productos próximos a vencer o días disponibles para su consumo.
3. Informar productos escasos con antelación en base al consumo usual y al tiempo de reposición o despacho por parte del proveedor.
4. Generar listado de productos necesarios y preparar pedidos a proveedores según disponibilidad de los mismos, costos, plazos de entrega y otros criterios como ofertas disponibles o periodicidad de las mismas.
5. Permitir agregar proveedores, habilitarlos y suspenderlos, incorporar proveedores fuera de línea por ingreso manual de sus datos (nombre o razón social, dirección, teléfono, correo electrónico, listado de productos que comercializa). Ejemplos de proveedores tipicamente fuera de línea son frutería, verdulería, carnicería, pescadería, heladería).
6. Permitir al dueño de la heladera consultar a distancia los productos que contiene y las cantidades de los mismos.
7. Permitir asignar proveedores deseables por productos.
8. Realizar seguimiento de pedidos y confirmación de los mismos cuando los ingresos son ingresados en su interior.
9. Reconocimiento de heladeras cercanas para optimización de pedidos.
10. Ajustar temperatura según los productos en el interior.
11. Detectar malos olores y determinar los productos que lo generan.
12. Definir usuarios de heladera con nombre o pseudónimo, género, edad, peso, gustos o preferencias y establecer perfil de consumo con el tiempo.
13. Generar estadísticas en base a productos comprados, consumidos y desperdiciados, frecuencia y proporción de consumo, características del consumo diario, semanal, mensual, anual, incluyendo valores nutricionales correspondientes a calorías, carbohidratos, azucares, grasas, fibras, sodio, en otros.

## Diagrama de casos de uso

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/usecases.puml)

## Descripcion de casos de uso

### Caso de uso Encender CU_ED

| Nombre del caso de uso     | Encender                                              |
|----------------------------|-------------------------------------------------------|
| __Identificador__          | CU_ED                                                 |
| __Actores__                | Consumidor                                            |
| __Entradas__               | Productos                                             |
| __Pre-condiciones__        | La heladera se encuentra enchufada a la red eléctrica |
|                            | La heladera se encuentra apagada                      |
| __Post-condiciones__       | La heladera esta encendida                            |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                                                       |
|:------:|-------------------------------------|-----------------------------------------------------------------------------|
| 1      | El consumidor enciende la heladera  | La heladera inicializa sus servicios                                        |
|        |                                     | La heladera detecta la puerta cerrada entonces ejecuta el caso de uso CU_CR |

#### Flujo alternativo CU_ED_ALT1: Detectar puerta abierta

| Paso   | Estimulo del actor                  | Respuesta del sistema                                                       |
|:------:|-------------------------------------|-----------------------------------------------------------------------------|
| 1.1    | El consumidor enciende la heladera  | La heladera inicializa sus servicio                                         |
|        |                                     | La heladera detecta la puerta abierta entonces ejecuta el caso de uso CU_AR |

### Caso de uso Abrir CU_AR

| Nombre del caso de uso     | Abrir                                          |
|----------------------------|------------------------------------------------|
| __Identificador__          | CU_AR                                          |
| __Actores__                | Consumidor                                     |
| __Entradas__               | -                                              |
| __Pre-condiciones__        | La heladera se encuentra encendida             |
|                            | La puerta de la heladera se encuentra cerrada  |
| __Post-condiciones__       | El contador de puerta abierta se incrementa    |
|                            | El reloj de puerta abierta se encuentra activo |

#### Flujo normal

| Paso   | Estimulo del actor                                   | Respuesta del sistema                                |
|:------:|------------------------------------------------------|------------------------------------------------------|
| 1      | El consumidor abre la puerta de la heladera          | La heladera incrementa el contador de puerta abierto |
|        |                                                      | La heladera inicia el reloj de puerta abierta        |
| 2      | El consumidor decide cerrar la puerta de la heladera | La heladera ejecuta el caso de uso CU_CR             |

#### Flujo alternativo CU_AR_ALT1: Poner producto

| Paso   | Estimulo del actor                                                   | Respuesta del sistema                  |
|:------:|----------------------------------------------------------------------|----------------------------------------|
| 2.1    | El consumidor decide poner un producto en el interior de la heladera | La heladera ejecuta el caso de uso CU_PP |

#### Flujo alternativo CU_AR_ALT2: Tomar producto

| Paso   | Estimulo del actor                                                 | Respuesta del sistema                    |
|:------:|--------------------------------------------------------------------|------------------------------------------|
| 2.1    | El consumidor decide tomar un producto del interior de la heladera | La heladera ejecuta el caso de uso CU_TP |

### Caso de uso Poner producto CU_PP

| Nombre del caso de uso     | Poner producto                                 |
|----------------------------|------------------------------------------------|
| __Identificador__          | CU_PP                                          |
| __Actores__                | Consumidor                                     |
| __Entradas__               | Producto                                       |
| __Pre-condiciones__        | Caso de uso CU_AR fue ejecutado con éxito      |
| __Post-condiciones__       | Uno o más productos en interior de la heladera |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      | El consumidor introduce en el interior de la heladera un producto | La heladera detecta que un objeto fue introducido en su interior       |
|        |                                                                   | La heladera registra que existen objetos en el interior que requieren detección |
| 2      | El consumidor cierra la puerta de la heladera                     | La heladera ejecuta el caso de uso CU_CR |

#### Flujo alternativo CU_PP_ALT1: Poner otro producto

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 2.1    | El consumidor decide poner en el interior de la heladera otro producto | Se ejecuta el paso 1 del flujo normal |

### Caso de uso Tomar producto CU_TP

| Nombre del caso de uso     | Tomar producto                                        |
|----------------------------|-------------------------------------------------------|
| __Identificador__          | CU_TP                                                 |
| __Actores__                | Consumidor                                            |
| __Entradas__               | Productos                                             |
| __Pre-condiciones__        | Caso de uso CU_AR fue ejecutado con éxito             |
| __Post-condiciones__       | Uno o más productos fuera del interior de la heladera |

#### Flujo normal

| Paso   | Estimulo del actor                                           | Respuesta del sistema                  |
|:------:|--------------------------------------------------------------|----------------------------------------|
| 1      | El consumidor retira del interior de la heladera un producto | La heladera detecta que un objeto fue retirado de su interior |
|        |                                                              | La heladera registra que se requiere detección de productos ya que existen menos productos en su interior |
| 2      | El consumidor cierra la puerta de la heladera | La heladera ejecuta el caso de uso CU_CR |

#### Flujo alternativo CU_TP_ALT1: Tomar otro producto

| Paso   | Estimulo del actor                                                   | Respuesta del sistema                 |
|:------:|----------------------------------------------------------------------|---------------------------------------|
| 2.1    | El consumidor decide tomar del interior de la heladera otro producto | Se ejecuta el paso 1 del flujo normal |

### Caso de uso Identificar productos CU_IP

| Nombre del caso de uso     | Identificar productos                                                             |
|----------------------------|-----------------------------------------------------------------------------------|
| __Identificador__          | CU_IP                                                                             |
| __Actores__                | -                                                                                 |
| __Entradas__               | Productos                                                                         |
| __Pre-condiciones__        | La puerta de la heladera está cerrada                                             |
| __Post-condiciones__       | Cero, uno o más alimentos en interior de la heladera identificados y registrados  |
|                            | Cero, uno o más productos u objetos en el interior no identificados y registrados |

#### Flujo normal

| Paso   | Estimulo del actor                                                  | Respuesta del sistema                  |
|:------:|---------------------------------------------------------------------|----------------------------------------|
| 1      | El consumidor introdujo o retiro uno o más productos de la heladera | La heladera notifica al consumidor que identificará los productos en su interior |
|        |                                                                     | La heladera escanea los productos para determinar su forma, colores, leyendas, fechas de elaboración y vencimiento y algún código de identificación |
|        |                                                                     | La heladera identifica todos los productos en su interior como alimentos |
|        |                                                                     | La heladera registra los alimentos detectados |
|        |                                                                     | La heladera ejecuta el caso de uso CU_DP |

#### Flujo alternativo CU_IP_ALT1: Productos no identificados

| Paso   | Estimulo del actor                                                  | Respuesta del sistema                  |
|:------:|---------------------------------------------------------------------|----------------------------------------|
| 1.1    | El consumidor introdujo o retiro uno o más productos de la heladera | La heladera notifica al consumidor que identificará los productos en su interior |
|        |                                                                     | La heladera escanea los productos para determinar su forma, colores, leyendas, fechas de elaboración y vencimiento y algún código de identificación |
|        |                                                                     | La heladera escanea los productos pero no logra identificarlos a todos por completo |
|        |                                                                     | La heladera registra los productos no identificados, tomando una foto de cada uno  para luego solicitar al consumidor la identificación manual |
|        |                                                                     | La heladera ejecuta el caso de uso CU_DP |

#### Flujo alternativo CU_IP_ALT2: Puerta abierta detectada durante identificación

| Paso   | Estimulo del actor                                                                 | Respuesta del sistema                  |
|:------:|------------------------------------------------------------------------------------|----------------------------------------|
| 1.1    | El consumidor introdujo o retiro uno o más productos de la heladera                | La heladera notifica al consumidor que identificará los productos en su interior |
|        |                                                                                    | La heladera escanea los productos para determinar su forma, colores, leyendas, fechas de elaboración y vencimiento y algún código de identificación |
| 1.2    | El consumidor abre la puerta de la heladera durante la identificación de productos | La heladera interrumpe la identificación de productos |
|        |                                                                                    | La heladera ejecuta el caso de uso CU_AR |

#### Flujo alternativo CU_IP_ALT3: Sin productos en el interior

| Paso   | Estimulo del actor                                            | Respuesta del sistema                  |
|:------:|---------------------------------------------------------------|----------------------------------------|
| 1.1    | El consumidor no introdujo ni retiró productos de la heladera | La heladera notifica al consumidor que identificará los productos en su interior |
|        |                                                               | La heladera escanea el interior sin detectar productos |
|        |                                                               | La heladera registra que no hay productos en su interior |

### Caso de uso Cerrar CU_CR

| Nombre del caso de uso     | Cerrar                                 |
|----------------------------|----------------------------------------|
| __Identificador__          | CU_CR                                  |
| __Actores__                | Consumidor                             |
| __Entradas__               | Productos                              |
| __Pre-condiciones__        | Caso de uso CU_AR ejecutado con éxito  |
| __Post-condiciones__       | Tiempo de puerta abierta registrado    |
|                            | La puerta de la heladera está cerrada  |

#### Flujo normal

| Paso   | Estimulo del actor                            | Respuesta del sistema                                      |
|:------:|-----------------------------------------------|------------------------------------------------------------|
| 1      | El consumidor cierra la puerta de la heladera | La heladera registra el tiempo del reloj de puerta abierta |
|        |                                               | La heladera ejecuta el caso de uso CU_IP                   |
|        |                                               | La heladera informa al consumidor los alimentos detectados y registrados y los productos u objetos no identificados |
| 2      | El consumidor recibe la notificación de alimentos detectados y registrados así como de productos u objetos no identificados y acepta el resultado | La heladera mantiene alerta activa en caso de productos u objetos no identificados, para que el consumidor recuerde continuar la identificación en otro momento |

#### Flujo alternativo CU_CR_ALT1: Sin productos en el interior

| Paso   | Estimulo del actor                            | Respuesta del sistema                                      |
|:------:|-----------------------------------------------|------------------------------------------------------------|
| 1.1    | El consumidor cierra la puerta de la heladera | La heladera registra el tiempo del reloj de puerta abierta |
|        |                                               | La heladera ejecuta el caso de uso CU_IP                   |
|        |                                               | La heladera no detecto productos en su interior por lo que notifica al consumidor que no hay productos en su interior mostrando la pantalla VSF_MK1 |

#### Flujo alternativo CU_CR_ALT2: Identificar y registrar productos en forma manual

| Paso   | Estimulo del actor                                                                                            | Respuesta del sistema                  |
|:------:|---------------------------------------------------------------------------------------------------------------|----------------------------------------|
| 2.1    | El consumidor recibe la notificación y decide identificar en forma manual aquellos productos no identificados | La heladera ejecuta el caso de uso CU_IM |

### Caso de uso Identificar productos manualmente CU_IM

| Nombre del caso de uso     | Identificar productos manualmente      |
|----------------------------|----------------------------------------|
| __Identificador__          | CU_IM                                  |
| __Actores__                | Consumidor                             |
| __Entradas__               | Productos                              |
| __Pre-condiciones__        | Uno o más productos u objetos en el interior no identificados |
| __Post-condiciones__       | Productos identificados como alimentos |

#### Flujo normal

| Paso   | Estimulo del actor                                                        | Respuesta del sistema                  |
|:------:|---------------------------------------------------------------------------|----------------------------------------|
| 1      | El consumidor acepta identificar manualmente productos en el interior de la heladera no identificados automáticamente                                                                      | La heladera presenta los productos no identificados mostrando la foto que tomó de cada uno de ellos |
| 2      | El consumidor selecciona uno de los productos no identificados            | La heladera solicita al consumidor que seleccione la categoría de producto |
| 3      | El consumidor selecciona la categoría alimento                            | La heladera solicita al consumidor que informe si el alimento dispone de código de identificación |
| 4      | El consumidor informa que el alimento dispone de código de identificación | La heladera solicita al consumidor que ingrese el código de identificación del alimento |
| 5      | El consumidor ingresa el código de identificación del alimento            | La heladera recupera los datos del alimento correspondiente al código de identificación |
|        |                                                                           | La heladera informa al consumidor los datos del alimento que recuperó mediante el código de identificación |
|        |                                                                           | La heladera solicita al consumidor modificar el peso del alimento ingresando el adecuado |
| 6      | El consumidor modifica el peso del alimento                               | La heladera solicita al consumidor confirmación para los datos del alimento identificado manualmente |
| 7      | El consumidor confirma la identificación manual del alimento              | La heladera registra el alimento, asociando los datos ingresados con la foto del mismo |
|        |                                                                           | La heladera informa al consumidor que el alimento identificado manualmente fue registrado |

#### Flujo alternativo CU_IM_ALT1: Producto a identificar no es alimento

| Paso   | Estimulo del actor                         | Respuesta del sistema                                               |
|:------:|--------------------------------------------|---------------------------------------------------------------------|
| 3.1    | El consumidor selecciona la categoría otro | La heladera informa al consumidor que solo debería haber alimentos en el interior |
|        |                                            | La heladera quita este producto del conjunto de productos no identificados |
|        |                                            | La heladera presenta los productos no identificados mostrando la foto que tomó de cada uno de ellos |
|        |                                            | El flujo continúa en el paso 2 del flujo normal |

#### Flujo alternativo CU_IM_ALT2: Codigo de identificacion no detectado o alimento sin código de identificación

| Paso   | Estimulo del actor                                                           | Respuesta del sistema                  |
|:------:|------------------------------------------------------------------------------|----------------------------------------|
| 4.1    | El consumidor informa que el alimento no dispone de código de identificación | La heladera solicita al consumidor que seleccione el tipo de producto |
| 4.2    | El consumidor selecciona el tipo de producto                                 | La heladera solicita al consumidor que ingrese el nombre del producto |
| 4.3    | El consumidor ingresa el nombre del producto                                 | La heladera solicita al consumidor que ingrese el peso del alimento |
| 4.4    | El consumidor ingresa el peso del alimento                                   | La heladera solicita al cliente confirmación para los datos del alimento identificado manualmente |
|        |                                                                              | El flujo continúa en el paso 7 del flujo normal |

#### Flujo alternativo CU_IM_ALT3: Fecha de vencimiento no detectada o alimento sin fecha de vencimiento

| Paso   | Estimulo del actor                                         | Respuesta del sistema                           |
|:------:|------------------------------------------------------------|-------------------------------------------------|
| 6.1    | El consumidor modifica el peso del alimento                | La heladera solicita al consumidor que ingrese la fecha de vencimiento del alimento |
| 6.2    | El consumidor ingresa la fecha de vencimiento del alimento | La heladera solicita al consumidor confirmación para los datos del alimento identificado manualmente |
|        |                                                            | El flujo continúa en el paso 7 del flujo normal |

### Caso de uso Comprar alimentos CU_CA

| Nombre del caso de uso     | Comprar alimentos                              |
|----------------------------|------------------------------------------------|
| __Identificador__          | CU_CA                                          |
| __Actores__                | Proveedor                                      |
| __Entradas__               | Registro de aprovisionamiento                  |
| __Pre-condiciones__        | Registro de aprovisionamiento actualizado      |
|                            | Medio de comunicación con proveedor disponible |
| __Post-condiciones__       | Registro de alimentos escasos actualizado      |
|                            | Registro de aprovisionamiento actualizado      |

#### Flujo normal

| Paso   | Estimulo del actor                                          | Respuesta del sistema                             |
|:------:|----------------------------------------------------------------------------|------------------------------------|
| 1      | El consumidor acepta iniciar la compra de alimentos escasos                | La heladera solicita al consumidor eliminar los alimentos escasos que no se deben reponer |
| 2      | El consumidor mantiene los alimentos escasos en la lista                   | La heladera solicita al consumidor modificar las cantidades de los alimentos escasos a reponer |
| 3      | El consumidor mantiene las cantidades de los alimentos escasos en la lista | La heladera ofrece al consumidor agregar alimentos para incluir en la lista de aprovisionamiento |
| 4      | El consumidor decide mantener los alimentos de la lista sin agregar más    | La heladera realiza la compra de alimentos  solicitando al consumidor ingresar los datos solicitados por el proveedor |
| 5      | El consumidor ingresa los datos solicitados por el proveedor               | La heladera solicita al consumidor confirmar la compra de alimentos |
| 6      | El consumidor confirma la compra de alimentos                              | La heladera informa al consumidor que la compra se concretó exitosamente, además del detalle de la compra |
|        |                                                                            | La heladera actualiza el registro de alimentos escasos con los detalles de la compra realizada |
|        |                                                                            | La heladera actualiza el registro de aprovisionamiento con los detalles de la compra realizada |

#### Flujo alternativo CU_CA_ALT1: Sin proveedor para realizar la compra de alimentos

| Paso   | Estimulo del actor                                                      | Respuesta del sistema                  |
|:------:|-------------------------------------------------------------------------|----------------------------------------|
| 4.1    | El consumidor decide mantener los alimentos de la lista sin agregar más | La heladera no dispone de proveedor alguno, y solicita al consumidor que ingrese un proveedor |
| 4.2    | El consumidor decide agregar un proveedor                               | La heladera ejecuta el caso de uso CU_AP |

#### Flujo alternativo CU_CA_ALT2: Medio de comunicación con proveedor caído

| Paso   | Estimulo del actor                                                      | Respuesta del sistema                  |
|:------:|-------------------------------------------------------------------------|----------------------------------------|
| 4.1    | El consumidor decide mantener los alimentos de la lista sin agregar más | La heladera no consigue establecer comunicación con el proveedor luego de varios intentos |
|        |                                                                         | La heladera informa al cliente que agenda el pedido dado que no es posible en este momento |

### Caso de uso Monitorear vencimiento de alimentos CU_MV

| Nombre del caso de uso     | Monitorear vencimiento de alimentos              |
|----------------------------|--------------------------------------------------|
| __Identificador__          | CU_MV                                            |
| __Actores__                | Tiempo                                           |
| __Entradas__               | Alimentos en el interior                         |
| __Pre-condiciones__        | La puerta de la heladera está cerrada            |
| __Post-condiciones__       | Registro de vencimiento de alimentos actualizado |

#### Flujo normal

| Paso   | Estimulo del actor                                             | Respuesta del sistema                           |
|:------:|----------------------------------------------------------------|-------------------------------------------------|
| 1      | Una vez cada 24 hs se controla el vencimiento de los alimentos | La heladera revisa el registro de alimentos en su interior y chequea, para cada alimento que dispone de fecha de vencimiento, si dicha fecha es próxima a la actual |
|        |                                                                | La heladera registra los alimentos vencidos, próximos a vencer y aquellos que no disponen de fecha de vencimiento |

#### Flujo alternativo CU_MV_ALT1: Puerta abierta detectada durante monitoreo

| Paso   | Estimulo del actor                                                          | Respuesta del sistema                  |
|:------:|-----------------------------------------------------------------------------|----------------------------------------|
| 1.1    | Una vez cada 24 hs se revisa el vencimiento de los alimentos                | La heladera chequea para cada alimento en su interior que dispone de fecha de vencimiento si dicha fecha es próxima a la actual |
| 1.2    | El consumidor abre la puerta de la heladera durante el proceso de monitoreo | La heladera interrumpe el monitoreo de vencimiento de los alimentos en su interior |
|        |                                                                             | La heladera registra que el monitoreo de vencimiento de alimentos en su interior está pendiente y lo agenda para iniciar luego de la identificación de alimentos |

#### Flujo alternativo CU_MV_ALT2: Monitoreo pendiente por interrupción

| Paso   | Estimulo del actor                                                     | Respuesta del sistema                  |
|:------:|------------------------------------------------------------------------|----------------------------------------|
| 1.1    | El monitoreo de vencimiento de alimentos fue agendado por interrupción | La heladera chequea para cada alimento en su interior que dispone de fecha de vencimiento si dicha fecha es próxima a la actual |
|        |                                                                        | La heladera registra los alimentos vencidos, próximos a vencer y aquellos que no disponen de fecha de vencimiento |

#### Flujo alternativo CU_MV_ALT3: Notificacion del resultado del monitoreo

| Paso   | Estimulo del actor                                                       | Respuesta del sistema                  |
|:------:|--------------------------------------------------------------------------|----------------------------------------|
| 1.1    | Durante los horarios en los cuales el consumidor hace uso de la heladera | La heladera recupera el registro de vencimiento de alimentos pendiente de informar al consumidor |
|        |                                                                          | La heladera ejecuta el caso de uso CU_NV |

### Caso de uso Notificar alimentos en vencimiento CU_NV

| Nombre del caso de uso     | Notificar alimentos en vencimiento                         |
|----------------------------|------------------------------------------------------------|
| __Identificador__          | CU_NV                                                      |
| __Actores__                | Tiempo, Consumidor                                         |
| __Entradas__               | Registro de vencimiento de alimentos                       |
| __Pre-condiciones__        | La puerta de la heladera está cerrada                      |
|                            | Registro de vencimiento de alimentos pendiente de informar |
| __Post-condiciones__       | ...                                                        |

#### Flujo normal

| Paso   | Estimulo del actor                                                           | Respuesta del sistema                  |
|:------:|------------------------------------------------------------------------------|----------------------------------------|
| 1      | El registro de vencimiento de alimentos contiene alimentos próximos a vencer | La heladera alerta al consumidor sobre los alimentos que están próximos a vencer |
| 2      | El consumidor revisa la lista de alimentos a vencer                          | La heladera solicita al consumidor iniciar la compra de los alimentos para reemplazar los que están próximos a vencer |
| 3      | El consumidor acepta iniciar la compra de alimentos escasos                  | La heladera ejecuta el caso de uso CU_CA |

#### Flujo alternativo CU_NV_ALT1: ...

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |

### Caso de uso Monitorear escasez de alimentos CU_ME

| Nombre del caso de uso     | Monitorear escasez de alimentos           |
|----------------------------|-------------------------------------------|
| __Identificador__          | CU_ME                                     |
| __Actores__                | Tiempo                                    |
| __Entradas__               | Registro de alimentos en el interior      |
| __Pre-condiciones__        | La puerta de la heladera está cerrada     |
| __Post-condiciones__       | Registro de alimentos escasos actualizado |
|                            | Registro de aprovisionamiento actualizado |

#### Flujo normal

| Paso   | Estimulo del actor                                                 | Respuesta del sistema                     |
|:------:|--------------------------------------------------------------------|-------------------------------------------|
| 1      | Durante los horarios en los cuales el consumidor hace uso de la heladera, a intervalos convenientes se controla el registro de alimentos | La heladera revisa el registro de alimentos en su interior y chequea, para cada alimento, si el peso total del mismo es suficiente para atender la demanda del consumidor |
|        |            | La heladera registra los alimentos escasos y aquellos para los que no fue posible determinarlo    |
|        |            | La heladera actualiza el registro de aprovisionamiento con los alimentos escasos y sus cantidades |
|        |            | La heladera ejecuta el caso de uso CU_NE                                                          |

#### Flujo alternativo CU_ME_ALT1: Puerta abierta detectada durante monitoreo

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    | Durante los horarios en los cuales el consumidor hace uso de la heladera, a intervalos convenientes se controla el registro de alimentos | La heladera revisa el registro de alimentos en su interior y chequea, para cada alimento, si el peso total del mismo es suficiente para atender la demanda del consumidor |
| 1.2    | El consumidor abre la puerta de la heladera durante el proceso de monitoreo | La heladera interrumpe el monitoreo de escasez de los alimentos en su interior |
|        |             | La heladera registra que el monitoreo de escasez de alimentos en su interior está pendiente y lo agenda para iniciar luego de la identificación de alimentos |

#### Flujo alternativo CU_ME_ALT2: Monitoreo pendiente por interrupción

| Paso   | Estimulo del actor                                                 | Respuesta del sistema                  |
|:------:|--------------------------------------------------------------------|----------------------------------------|
| 1.1    | El monitoreo de escasez de alimentos fue agendado por interrupción | La heladera revisa el registro de alimentos en su interior y chequea, para cada alimento, si el peso total del mismo es suficiente para atender la demanda del consumidor                                       |
|        |                                                                    | La heladera registra los alimentos escasos y aquellos para los que no fue posible determinarlo |
|        |                                                                    | La heladera actualiza el registro de aprovisionamiento con los alimentos escasos y sus cantidades |
|        |                                                                    | La heladera ejecuta el caso de uso CU_NE |

### Caso de uso Notificar escasez de alimentos CU_NE

| Nombre del caso de uso     | Notificar escasez de alimentos                          |
|----------------------------|---------------------------------------------------------|
| __Identificador__          | CU_NE                                                   |
| __Actores__                | Tiempo, Consumidor                                      |
| __Entradas__               | Registro de alimentos escasos                           |
| __Pre-condiciones__        | La puerta de la heladera está cerrada                   |
|                            | Alimentos escasos                                       |
| __Post-condiciones__       | Registro de postergación de compra de alimentos escasos |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      | El registro de alimentos escasos contiene alimentos que requieren reposición | La heladera alerta al consumidor sobre los alimentos que requieren reposición informando la lista de reposición |
| 2      | El consumidor revisa la lista                                                | La heladera solicita al consumidor iniciar la compra de los alimentos escasos |
| 3      | El consumidor acepta iniciar la compra de alimentos escasos                  | La heladera ejecuta el caso de uso CU_CA |

#### Flujo alternativo CU_NE_ALT1: Postergar compra de alimentos escasos

| Paso   | Estimulo del actor                                            | Respuesta del sistema                  |
|:------:|---------------------------------------------------------------|----------------------------------------|
| 2.1    | El consumidor revisa la lista                                 | La heladera solicita al consumidor iniciar la compra de los alimentos escasos |
| 2.2    | El consumidor decide postergar la compra de alimentos escasos | La heladera solicita al consumidor informar el lapso de tiempo que la compra será postergada |
| 2.3    | El consumidor informa el tiempo de postergación de la compra  | La heladera registra la postergación de la compra de alimentos escasos |

#### Flujo alternativo CU_NE_ALT2: Aprobacion de compra de alimentos escasos

| Paso   | Estimulo del actor                                          | Respuesta del sistema                  |
|:------:|-------------------------------------------------------------|----------------------------------------|
| 1.1    | La reposición de alimentos escasos fue postergada           | La heladera informa al consumidor los alimentos que requieren reposición |
| 1.2    | El consumidor revisa el listado de alimentos escasos        | La heladera solicita al consumidor iniciar la compra de los alimentos escasos |
| 1.3    | El consumidor acepta iniciar la compra de alimentos escasos | La heladera ejecuta el caso de uso CU_CA |

## Mockups

## Diagramas del modelo de dominio

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/classes.puml)

## Diagramas de secuencia

### Flujos normal y alternativo para Encender 

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_ed_normal_and_alt1_flows.puml)

### Flujo normal para Abrir

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_ar_normal_flow.puml)

### Flujos alternativos para Abrir

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_ar_alt1_flow.puml)

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_ar_alt2_flow.puml)

### Flujos normal y alternativo para Poner producto

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_pp_normal_and_alt1_flows.puml)

### Flujos normal y alternativo para Tomar producto

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_tp_normal_and_alt1_flows.puml)

### Flujo normal para Identificar Producto

### Flujo normal para Cerrar

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_cr_normal_flow.puml)

### Flujos alternativos para Cerrar

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_cr_alt1_flow.puml)

![system overview](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mgardos/vsfridge/master/src/site/resources/uc_cr_alt2_flow.puml)

## Diagramas de actividad

### Encendido de la heladera

### Abrir la puerta de la heladera

### Cerrar la puerta de la heladera

### Identificar productos

## Pendientes

+ [x] Describir las partes involucradas en el diagrama esquematico
+ [ ] Incluir datos sensoriales del producto
+ [x] Agregar detalle sobre capacidades, explicando cada característica y en particular las que incorpora la heladera virtual
+ [ ] Incluir diagrama de componentes
+ [ ] Cada diagrama de modelado requiere una explicación, detallar clases y métodos
+ [ ] Incluir detalles de implementación del prototipo, infraestructura, caso de pruebas, pantallas de usuario
+ [ ] Resultados obtenidos para cada caso de prueba

## Referencias

+ [Heladera inteligente Samsung](https://www.samsung.com/us/home-appliances/refrigerators/4-door-flex/28-cu-ft-4-door-flex-with-21-5-in-connected-touch-screen-family-hub-refrigerator-rf28n9780sr-aa/)
+ [Heladera inteligente LG](https://www.lg.com/us/refrigerators/lg-LNXS30996D-door-in-door)
+ [Heladera inteligente Hitachi](https://www.homeappliances.hitachi.com/sg/eng/products/refrigerators/made-in-japan-iot-connected/r-zxc740ks.html?productId=r-zxc740ks)
+ [Aplicacion movil para heladera Hitachi](https://www.homeappliances.hitachi.com/global/app/ref/series01/index.html)
+ [Heladera pseudo inteligente Sharp](http://www.sharphomeappliances.com/products/cooling/fridge-freezers/sj-f1560eva-1442)
+ [Heladera inteligente Bosch](https://www.bosch-home.co.uk/bosch-innovations/homeconnect/homeconnect-fridges#tab-navigation)
