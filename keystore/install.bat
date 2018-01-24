keytool -genkey -v -keystore dev.keystore -alias devkey -keypass 123456 -storepass 123456 -keyalg RSA -keysize 1024 -validity 9000
keytool -genkey -v -keystore local.keystore -alias localkey -keypass 123456 -storepass 123456 -keyalg RSA -keysize 1024 -validity 9000
keytool -genkey -v -keystore staging.keystore -alias stagingkey -keypass 123456 -storepass 123456 -keyalg RSA -keysize 1024 -validity 9000
keytool -genkey -v -keystore production.keystore -alias productionkey -keypass 123456 -storepass 123456 -keyalg RSA -keysize 1024 -validity 9000