import ballerina/http;

# A service representing a network-accessible API
# bound to port `8080`.
service / on new http:Listener(8080) {

    # A resource for generating echos
    # + sound - the input string name
    # + return - string sound
    resource function get echo(string sound) returns string|error {
        // Send a response back to the caller.
        return sound;
    }

    # A resource for the definition of an echo
    # + return - definition of echo
    resource function get echo/definition() returns string {
        return "A sound or series of sounds caused by the reflection of sound waves from a surface back to the listener.";
    }
}
