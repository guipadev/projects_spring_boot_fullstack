

## Pto por defecto
8081

## Autenticación y generación de Token
POST - http://localhost:8081/publico/authenticate

{
"usuario": "jcabelloc",
"clave": "secreto"
}

## Uso de token jwt para llamar apis rest
GET - http://localhost:8081/mensaje

