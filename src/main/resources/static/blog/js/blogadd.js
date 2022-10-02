// use Quill to create a rich text editor
// https://quilljs.com/
var quill = new Quill('#editor-container', {
    modules: {
        toolbar: [
            [{ 'font': [] }], // font family    
            [{ 'header': [1, 2, 3, 4, 5, 6, false] }], // header dropdown
            ['bold', 'italic', 'underline', 'strike'], // toggled buttons   
            ['blockquote', 'code-block'], // blocks
            [{ 'list': 'ordered' }, { 'list': 'bullet' }], // lists
            [{ 'script': 'sub' }, { 'script': 'super' }], // superscript/subscript
            [{ 'indent': '-1' }, { 'indent': '+1' }], // outdent/indent
            [{ 'direction': 'rtl' }], // text direction
            //[{ 'size': ['small', false, 'large', 'huge'] }], // custom dropdown
            [{ 'color': [] }, { 'background': [] }], // dropdown with defaults from theme
            [{ 'align': [] }], // text align
            ['clean'], // remove formatting button
            ['link', 'image', 'video'] // link and image, video 
        ]
    },
    theme: 'snow' // or 'bubble'
});
quill.on('text-change', function(delta, oldDelta, source) {
    $('#blog_content').val(quill.root.innerHTML);
});
//require user to enter all fileds before submitting
$('#blogadd').submit(function() {
    if ($('#blog_title').val() == '') {
        alert('Please enter a title');
        return false;
    }
    if ($('#blog_content').val() == '') {
        alert('Please enter some content');
        return false;
    }
    if ($('#blog_category').val() == '') {
        alert('Please choice a category');
        return false;
    }
    //blog_description, blog_content
    if ($('#blog_description').val() == '') {
        alert('Please enter a description');
        return false;
    }
    // blog_content not null\
    if ($('#blog_content').val() == '') {
        alert('Please enter some content');
        return false;
    }
    return true;
});

// var form = document.querySelector('form');
// form.onsubmit = function() {
//     var about = document.querySelector('input[name=content]');
//     about.value = quill.root.innerHTML;
//     //console log results
//     console.log("Submitted", $(form).serialize(), $(form).serializeArray());
//     //return false to submit form via ajax or set action attribute of form element

//     //alert check to see if form is submitting
//     alert("Submitted", $(form).serialize(), $(form).serializeArray());
//     return false;
// }