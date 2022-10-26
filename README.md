# Demo project for AWS location service using the aws-sdk-java-v2

To use this program be sure to have a properly configured location service at AWS already set up.
For the sake of simplicity the project assumes the location index is called "explore.place". Also
be sure to have your local AWS configuration set up correctly. This might be done using a
configuration file called "~/.aws/credentials":

```text
[default]
aws_access_key_id = your_access_key
aws_secret_access_key = your_secret_key
region = eu-central-1
```

The failure is triggered by the setting "region". In 2.17.X we get a result, in 2.18.X
an unknown host exception is thrown.

You might just start the program and browse to "localhost:8080/api/geo" or use the provided
test in "DemoControllerTest".