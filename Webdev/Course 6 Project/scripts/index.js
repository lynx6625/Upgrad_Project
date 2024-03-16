document.addEventListener('DOMContentLoaded', function () {
    var signupModal = document.getElementById("signupModal");
    var signinModal = document.getElementById("signinModal");
    var cpModal = document.getElementById("cpModal");

    var signupBtn = document.getElementById("signup");
    var signinBtn = document.getElementById("signin");
    var cpBtn = document.getElementById("cp");

    var signupSpan = signupModal.querySelector(".close");
    var signinSpan = signinModal.querySelector(".close2");
    var cpSpan = cpModal.querySelector(".close3");

    // Function to open sign-up modal
    function openSignup() {
        signupModal.style.display = "flex";
    }

    // Function to close sign-up modal
    function closeSignup() {
        signupModal.style.display = "none";
    }

    // Function to open sign-in modal
    function openSignin() {
        signinModal.style.display = "flex";
    }

    // Function to close sign-in modal
    function closeSignin() {
        signinModal.style.display = "none";
    }

    function opencp() {
        cpModal.style.display = "flex";
    }
    function closecp() {
        cpModal.style.display = "none";
    }

    // Event listener for sign-up button
    signupBtn.onclick = openSignup;

    // Event listener for close button on sign-up modal
    signupSpan.onclick = closeSignup;

    // Event listener for sign-in button
    signinBtn.onclick = openSignin;

    // Event listener for close button on sign-in modal
    signinSpan.onclick = closeSignin;

    cpBtn.onclick = opencp;
    cpSpan.onclick = closecp;

    if(signupSpan) signupSpan.onclick = closeSignup;
    if(signinSpan) signinSpan.onclick = closeSignin;

    
    window.onclick = function(event) {
        if (event.target == signupModal) {
            closeSignup();
        } else if (event.target == signinModal) {
            closeSignin();
        }
    };

    var switchToSignupLinks = document.querySelectorAll(".switch-to-signup");
    switchToSignupLinks.forEach(function(link) {
        link.onclick = function() {
            closeSignin();
            openSignup();
            return false;
        };
    });
});