# author: AlejandroPolo
# language: es

Característica: Flujo de compra en la pagina saucedemo

  Yo como TAE(Test automation engineer)
  Quiero realizar una prueba E2E
  Para la compra de productos en la pagina saucedemo

  @purchaseWithAuthenticationSuccess
  Escenario: Compra de dos productos, con autenticacion de usuario exitosa.
    Dado "alejandro" desea realizar una compra por pagina web
    Cuando realiza todo el proceso de compra
    Entonces al finalizar obtiene una confirmación "THANK YOU FOR YOUR ORDER"


