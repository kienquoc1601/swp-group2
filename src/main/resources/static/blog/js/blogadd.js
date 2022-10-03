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
    // //category option is must be selected different from default
    // blog_content not null
    if ($('#blog_content').val() == '') {
        alert('Please enter some content');
        return false;
    }
    return true;
});