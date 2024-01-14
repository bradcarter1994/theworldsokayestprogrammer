// val timestamp: java.sql.Timestamp = java.sql.Timestamp(1)
val timestamp: java.sql.Timestamp = null

val expirationDate = Option(timestamp).map(_.toInstant.toEpochMilli)