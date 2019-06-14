window.onload = function (){


    $(document).ready(Principal);
    function Principal(){
        //dui
        var flag1 = true;
        $(document).on('keydown','[id=dui]',function(e){
            if($(this).val().length == 8 && flag1) {
                $(this).val($(this).val()+"-");
                flag1 = false;
            }
        });
        //telefono
        var flag2 = true;
        $(document).on('keydown','[id=telefono]',function(e){
            if($(this).val().length == 4 && flag2) {
                $(this).val($(this).val()+"-");
                flag2 = false;
            }
        });

    }
  
}