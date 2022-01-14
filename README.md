# FirestoreTemplate

Uses spring-boot-aop's Aspect to "intercept" method calls with a given annotation. In this case, @EncryptedOperation.
The Aspect then checks if any fields in the method argument has the @Encrypted annotation. If it does, we want to encrypt this field.
