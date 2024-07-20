function average(a,b){
    return (a+b)/2;
}

function showAlert(){
    window.alert("This is an alert js function");
}

function displayFullName(){
    var firstName = document.getElementById("firstNameValue").value;
    var lastName = document.getElementById("lastNameValue").value;
    var fullName="";
    var fullNameElement=  document.getElementById("fullName");

    fullNameElement.innerHTML="";

    if(firstName === "" && lastName === ""){
        window.alert("Please enter both first name and last name");
       }
    else if(firstName === "" ){
        window.alert("Please enter first name");
        }
    else if(lastName === "" ){
        window.alert("Please enter last name");
    } else {
       fullNameElement.innerHTML = upperCaseFirstLetter(firstName) + " " + upperCaseFirstLetter(lastName);
    }
}

function upperCaseFirstLetter(word){
    return word.charAt(0).toUpperCase() + word.slice(1);
}