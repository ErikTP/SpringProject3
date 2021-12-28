var myJSObj = {
    firstName: "Marcus",
    lastname: "Henriksson",
    age : 32,
    listOfPets : ["Herr Nilsson", "Nicke Nyfiken", "Griseknorren"]
}

myJSObj.age =545;

delete myJSObj.listOfPets;

let myJSONobj = JSON.stringify(myJSObj);

document.write(myJSONobj);