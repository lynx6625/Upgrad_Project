document.addEventListener("DOMContentLoaded", function () {
  var signupModal = document.getElementById("signupModal");
  var signinModal = document.getElementById("signinModal");
  var cpModal = document.getElementById("cpModal");

  var signupBtn = document.getElementById("signup");
  var signinBtn = document.getElementById("signin");
  var cpBtn = document.getElementById("cp");

  var signupSpan = signupModal.querySelector(".close");
  var signinSpan = signinModal.querySelector(".close2");
  var cpSpan = cpModal.querySelector(".close3");

  function openSignup() {
    signupModal.style.display = "flex";
  }

  function closeSignup() {
    signupModal.style.display = "none";
  }

  function openSignin() {
    signinModal.style.display = "flex";
  }

  function closeSignin() {
    signinModal.style.display = "none";
  }

  function opencp() {
    cpModal.style.display = "flex";
  }
  function closecp() {
    cpModal.style.display = "none";
  }

  signupBtn.onclick = openSignup;

  signupSpan.onclick = closeSignup;

  signinBtn.onclick = openSignin;

  signinSpan.onclick = closeSignin;

  cpBtn.onclick = opencp;
  cpSpan.onclick = closecp;

  if (signupSpan) signupSpan.onclick = closeSignup;
  if (signinSpan) signinSpan.onclick = closeSignin;

  window.onclick = function (event) {
    if (event.target == signupModal) {
      closeSignup();
    } else if (event.target == signinModal) {
      closeSignin();
    }
  };

  var switchToSignupLinks = document.querySelectorAll(".switch-to-signup");
  switchToSignupLinks.forEach(function (link) {
    link.onclick = function () {
      closecp();
      openSignup();
      return false;
    };
  });
});
