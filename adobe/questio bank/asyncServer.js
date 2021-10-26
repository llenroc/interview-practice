// server.js
const service = (data, options, callback) => {
    return (data, error) => {
        error? console.error(error): console.log(data);
    }
}

//client
const response = service(data, options, (data, error) => {
    
})