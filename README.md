# Heladera Inteligente Virtual

## Contenidos
+ [Descripcion de la propuesta](#descripcion-de-la-propuesta)
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
  + [Encendido de heladera con puerta abierta y sin productos en el interior](#encendido-de-heladera-con-puerta-abierta-y-sin-productos-en-el-interior)
  + [Encendido de heladera con puerta cerrada y sin productos en el interior](#encendido-de-heladera-con-puerta-cerrada-y-sin-productos-en-el-interior)
  + [Heladera con puerta abierta y productos en su interior](#heladera-con-puerta-abierta-y-productos-en-su-interior)
+ [Diagramas de actividad](#diagramas-de-actividad)

## Descripcion de la propuesta

Algunas de las grandes compañías de electrónica y electrodomésticos han comenzado a dar los primeros pequeños pasos en la dirección de lo que podría llegar a considerarse la heladera inteligente. En algunos países desarrollados e industrializados se comercializan en la actualidad  heladeras publicitadas como inteligentes. Aquello que se considera inteligente puede variar drásticamente dependiendo de diversos factores, como el sujeto, el objeto, el contexto, la escala, las expectativas, en otros. La heladera que este trabajo práctico considera inteligente se encuentra descrita mediante los usos que se espera hacer de ella, enunciados en la sección Usos de la heladera inteligente.

El diagrama esquematico presenta el entorno en el cual opera la heladera inteligente. Los actores principales que se observan en el diagrama son la heladera inteligente y el consumidor, que hace uso de ella. Otros actores o participantes, que se consideran secundarios, son otras heladeras inteligentes vecinas o próximas, proveedores de alimentos o productos alimenticios, tales como supermercados, tiendas en línea o fuera de línea, y despachantes de productos, ya sea propios de los proveedores mencionados o independientes.

(Diagrama esquematico pendiente)

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

|                                                 | Model 1 | Model 2 |
| ------------------------------------------------|:-------:|:-------:|
| Conectividad WiFi                               |         |         |
| Control por aplicación móvil                    |         |         |
| Instalacion de aplicaciones                     |         |         |
| Comando por voz                                 |         |         |
| Alerta de puerta abierta                        |         |         |
| Ajuste de temperatura                           |         |         |
| Ajuste de humedad                               |         |         |
| Ajuste de filtro de aire                        |         |         |
| Activacion de hielo adicional                   |         |         |
| Ajuste de ahorro de energia                     |         |         |
| Visor de consumo de energia                     |         |         |
| Visor de apertura de puertas                    |         |         |
| Crear perfil del usuario                        |         |         |
| Enviar mensajes a otros usuarios                |         |         |
| Enviar lista de tareas a otros usuarios         |         |         |
| Crear agenda de actividades para usuario        |         |         |
| Crear mensajes y dibujos en las puertas         |         |         |
| Mostrar fotos en las puertas                    |         |         |
| Reproducir video en las puertas                 |         |         |
| Reproducir musica                               |         |         |
| Transmitir musica a dispositivos compatibles    |         |         |
| Planificar comida con alimentos en el interior  |         |         |
| Crear lista de compras                          |         |         |
| Ver alimentos en el interior a puerta cerrada   |         |         |
| Definir alarma para compra de alimentos         |         |         |
| Leer recetas al usuario                         |         |         |
| Tomar dictado del usuario                       |         |         |
| Realizar compra de alimentos                    |         |         |
| Navegar sitios en Internet                      |         |         |
| Controlar otros dispositivos inteligentes       |         |         |
| Detectar e identificar productos en el interior |         |         |
| Detectar cantidad de alimentos                  |         |         |
| Monitorear vencimiento de alimentos             |         |         |
| Administrar compra de alimentos segun consumo   |         |         |

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

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_AR_ALT1: Poner producto

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 2.1    |                                     |                                        |

#### Flujo alternativo CU_AR_ALT2: Tomar producto

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 2.1    |                                     |                                        |

### Caso de uso Poner producto CU_PP

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_PP_ALT1: Poner otro producto

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 2.1    |                                     |                                        |

### Caso de uso Tomar producto CU_TP

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_TP_ALT1: Tomar otro producto

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 2.1    |                                     |                                        |

### Caso de uso Identificar productos CU_IP

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_IP_ALT1: Productos no identificados

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |

#### Flujo alternativo CU_IP_ALT2: Puerta abierta detectada durante identificacion

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |
| 1.2    |                                     |                                        |

#### Flujo alternativo CU_IP_ALT3: Sin productos en el interior

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |

### Caso de uso Cerrar CU_CR

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_CR_ALT1: Sin productos en el interior

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |

#### Flujo alternativo CU_CR_ALT2: Identificar y registrar productos en forma manual

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 2.1    |                                     |                                        |

### Caso de uso Identificar productos manualmente CU_IM

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_IM_ALT1: Producto a identificar no es alimento

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 3.1    |                                     |                                        |

#### Flujo alternativo CU_IM_ALT2: Codigo de identificacion no detectado o alimento sin codigo

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 4.1    |                                     |                                        |
| 4.2    |                                     |                                        |
| 4.3    |                                     |                                        |
| 4.4    |                                     |                                        |

#### Flujo alternativo CU_IM_ALT3: Fecha de vencimiento no detectada o alimento sin fecha

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 6.1    |                                     |                                        |
| 6.2    |                                     |                                        |

### Caso de uso Comprar alimentos CU_CA

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_CA_ALT1: Sin proveedor para realizar la compra de alimentos

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 4.1    |                                     |                                        |
| 4.2    |                                     |                                        |

#### Flujo alternativo CU_CA_ALT2: Medio de comunicacion con proveedor caido

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 4.1    |                                     |                                        |

### Caso de uso Monitorear vencimiento de alimentos CU_MV

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_MV_ALT1: Puerta abierta detectada durante monitoreo

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |
| 1.2    |                                     |                                        |

#### Flujo alternativo CU_MV_ALT2: Monitoreo pendiente por interrupcion

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |

#### Flujo alternativo CU_MV_ALT3: Notificacion del resultado del monitoreo

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |

### Caso de uso Notificar alimentos en vencimiento CU_NV

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_NV_ALT1: ...

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |

### Caso de uso Monitorear escasez de alimentos CU_ME

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_ME_ALT1: Puerta abierta detectada durante monitoreo

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |
| 1.2    |                                     |                                        |

#### Flujo alternativo CU_ME_ALT2: Monitoreo pendiente por interrupcion

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |

### Caso de uso Notificar escasez de alimentos CU_NE

| Nombre del caso de uso     |                                        |
|----------------------------|----------------------------------------|
| __Identificador__          |                                        |
| __Actores__                |                                        |
| __Entradas__               |                                        |
| __Pre-condiciones__        |                                        |
| __Post-condiciones__       |                                        |

#### Flujo normal

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1      |                                     |                                        |

#### Flujo alternativo CU_NE_ALT1: Postergar compra de alimentos escasos

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 2.1    |                                     |                                        |
| 2.2    |                                     |                                        |
| 2.3    |                                     |                                        |

#### Flujo alternativo CU_NE_ALT2: Aprobacion de compra de alimentos escasos

| Paso   | Estimulo del actor                  | Respuesta del sistema                  |
|:------:|-------------------------------------|----------------------------------------|
| 1.1    |                                     |                                        |
| 1.2    |                                     |                                        |
| 1.3    |                                     |                                        |

## Mockups

## Diagramas del modelo de dominio

## Diagramas de secuencia

### Encendido de heladera con puerta abierta y sin productos en el interior

### Encendido de heladera con puerta cerrada y sin productos en el interior

### Heladera con puerta abierta y productos en su interior

## Diagramas de actividad

### Encendido de la heladera

### Abrir la puerta de la heladera

### Cerrar la puerta de la heladera

### Identificar productos

## Pendientes

+ Describir las partes involucradas en el diagrama esquematico
+ Incluir datos sensoriales del producto (?)
+ Agregar detalle sobre capacidades, explicando cada característica y en particular las que incorpora la heladera virtual
+ Incluir diagrama de componentes
+ Cada diagrama de modelado requiere una explicación, detallar clases y métodos (?)
+ Incluir detalles de implementación del prototipo, infraestructura, caso de pruebas, pantallas de usuario
+ Resultados obtenidos para cada caso de prueba
