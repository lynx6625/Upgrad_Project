var postToDelete = null;

function openDeleteModal(postId) {
    postToDelete = postId;
    document.getElementById('deleteModal').style.display = 'flex';
}

var trashIcons = document.querySelectorAll('.trash');


trashIcons.forEach(function(icon) {
    icon.addEventListener('click', function() {
        var postId = this.getAttribute('data-post-id');
        openDeleteModal(postId);
    });
});

var yesBtn = document.getElementById('delyes');
var noBtn = document.getElementById('delno');


function handleDelete() {
    if (postToDelete !== null) {
        var postElements = document.querySelectorAll('.postdiv');
        for (var i = 0; i < postElements.length; i++) {
            var postElement = postElements[i];
            var trashIcon = postElement.querySelector('.trash');
            if (trashIcon && trashIcon.getAttribute('data-post-id') === postToDelete) {
                postElement.remove();
                break;
            }
        }

        console.log('Deleting post with id:', postToDelete);
        // Reset postToDelete to null
        postToDelete = null;
    }
    closeModal(); // Close the modal
}



function closeModal() {
    document.getElementById('deleteModal').style.display = 'none';
}

// Attach event listeners to the modal buttons
yesBtn.addEventListener('click', handleDelete);
noBtn.addEventListener('click', closeModal);