val dbSession = new DatabaseSession(config)
val queryString = "SELECT * FROM ..."
val resultSet = dbSession.query(queryString)
resultSet foreach { row => 
  val expirationDate = Some(row.getTimestamp("expirationDate")).map(_.toInstant.toEpochMilli)
  // ...
}