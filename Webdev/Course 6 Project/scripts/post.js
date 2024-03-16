const edit1 = document.getElementById("edit1");
const edit2 = document.getElementById("edit2");
const edit3 = document.getElementById("edit3");
const edit_button = document.getElementById("edit");
const edit_button_text = edit_button.querySelector('span');
const edit_icon = edit_button.querySelector('i');


// Initialize a flag to track editing state
let isEditing = false;

edit_button.addEventListener("click", function() {
    if (!isEditing) {
        // Switch to editing mode
        edit1.contentEditable = "true";
        edit2.contentEditable = "true";
        edit3.contentEditable = "true";
        edit1.style.border = "#dddbdb";
        edit2.style.border = "#dddbdb";
        edit3.style.border = "#dddbdb";
        

        edit_button_text.textContent = "Save";
        edit_icon.className = "fa fa-floppy-o";
        
    } else {

        edit1.contentEditable = "false";
        edit2.contentEditable = "false";
        edit3.contentEditable = "false";
        edit1.style.backgroundColor = "";
        edit2.style.backgroundColor = "";
        edit3.style.backgroundColor = "";
        

        edit_button_text.textContent = "Edit";
        edit_icon.className = "fa fa-pencil-square-o";
    }
    

    isEditing = !isEditing;
});

document.addEventListener('DOMContentLoaded', () => {
    const likeButton = document.getElementById('likebutton');
    const likeCounter = document.getElementById('likecounter');
    let likeCount = 0;

    likeButton.addEventListener('click', () => {
        likeCount++;
        updateLikeText();
        likeButton.textContent = 'Liked!';
    });

    function updateLikeText() {
        if (likeCount === 1) {
            likeCounter.textContent = `${likeCount} person likes this!`;
        } else {
            likeCounter.textContent = `${likeCount} people like this!`;
        }
    }
});


var commentBtn = document.getElementById('commentbutton');
var commentBox = document.getElementById('commentBox');
var commentSection = document.getElementById('allcomments');

// Add an event listener for the click event on the button
commentBtn.addEventListener('click', function() {
    // Get the value of the comment box
    var commentText = commentBox.value.trim();
    // Check if the comment box is not empty
    if(commentText) {
        // Create a new div element to hold the comment
        var newComment = document.createElement('div');
        // Set the text of the new div to the comment text
        newComment.textContent = commentText;
        // Append the new div to the comment section
        commentSection.appendChild(newComment);
        // Clear the comment box
        commentBox.value = '';
    }
});



