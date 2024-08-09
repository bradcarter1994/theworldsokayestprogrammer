val inventoryServiceReponse: Option[Boolean] = {
  Some(true)
}

val paymentsServiceResponse: Option[Boolean] = {
  Some(false)
}

val complianceServiceResponse: Option[Boolean] = {
  Some(true)
}

val orderPlacementServiceResponse: Option[Boolean] = for {
  weHaveInventory <- inventoryServiceReponse
  customerHasMoney <- paymentsServiceResponse
  laywersSayOk <- complianceServiceResponse
} yield weHaveInventory && customerHasMoney && laywersSayOk

println(orderPlacementServiceResponse)

println(s"${inventoryServiceReponse.size} X ${paymentsServiceResponse.size} X ${complianceServiceResponse.size} = ${orderPlacementServiceResponse.size}")