val inventoryServiceReponse: Option[Boolean] = {
  Some(true) // None
}

val paymentsServiceResponse: Option[Boolean] = {
  Some(true) // None
}

val complianceServiceResponse: Option[Boolean] = {
  Some(true) // None
}

val orderPlacementServiceResponse: Option[Boolean] = for {
  weHaveInventory <- inventoryServiceReponse
  customerHasMoney <- paymentsServiceResponse
  laywersSayOk <- complianceServiceResponse
} yield weHaveInventory && customerHasMoney && laywersSayOk

println(orderPlacementServiceResponse)

println(s"${inventoryServiceReponse.size} X ${paymentsServiceResponse.size} X ${complianceServiceResponse.size} = ${orderPlacementServiceResponse.size}")