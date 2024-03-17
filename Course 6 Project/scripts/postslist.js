var postToDelete = null;

function openDeleteModal(postId) {
  postToDelete = postId;
  document.getElementById("deleteModal").style.display = "flex";
}

var trashIcons = document.querySelectorAll(".trash");

trashIcons.forEach(function (icon) {
  icon.addEventListener("click", function () {
    var postId = this.getAttribute("data-post-id");
    openDeleteModal(postId);
  });
});

var yesBtn = document.getElementById("delyes");
var noBtn = document.getElementById("delno");

function handleDelete() {
  if (postToDelete !== null) {
    var postElements = document.querySelectorAll(".postdiv");
    for (var i = 0; i < postElements.length; i++) {
      var postElement = postElements[i];
      var trashIcon = postElement.querySelector(".trash");
      if (
        trashIcon &&
        trashIcon.getAttribute("data-post-id") === postToDelete
      ) {
        postElement.remove();
        break;
      }
    }

    console.log("Deleting post with id:", postToDelete);
    postToDelete = null;
  }
  closeModal();
}

function closeModal() {
  document.getElementById("deleteModal").style.display = "none";
}

yesBtn.addEventListener("click", handleDelete);
noBtn.addEventListener("click", closeModal);

document.addEventListener("DOMContentLoaded", function () {
  const ellipsisButtons = document.querySelectorAll(".el");

  ellipsisButtons.forEach((button) => {
    button.addEventListener("click", function (e) {
      const postDiv = this.closest(".postdiv");
      const poster = postDiv.querySelector(".poster p").innerText;
      const postTitle = postDiv.querySelector(".posttitle p").innerText;
      const postContent = postDiv.querySelector(".postbody > p").innerText;

      localStorage.setItem("poster", poster);
      localStorage.setItem("postTitle", postTitle);
      localStorage.setItem("postContent", postContent);

      window.location.href = "../html/post.html";
    });
  });
});
