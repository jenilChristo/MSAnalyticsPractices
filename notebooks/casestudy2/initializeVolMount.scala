// Databricks notebook source
val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "b81c3076-688c-453f-97c4-4c4a1dc67f96",
  "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope = "azure-key-vault", key = "databricksjelazarsecret"),
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/19f975b7-59ac-4487-baad-c52496d31d91/oauth2/token")

val mounts = dbutils.fs.mounts()
val isExist = false
var mountPath = "mnt/data"

for(mount <- mounts){
  if(mount == mountPath){
    isExist = true
  }
  break
}

 

// COMMAND ----------

