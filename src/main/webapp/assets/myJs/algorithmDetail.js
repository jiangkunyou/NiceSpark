/**
 * Created by jiangkunyou on 15/11/30.
 */
$(function(){

    $("#inputfile").change(function(){
        $.each(this.files, function(){
            var divNode = $("<div></div>");
            var iNode = $("<i class='am-icon-trash-o am-icon-fw'></i>").click(function(){
                if($(".am-offcanvas-content div").length == 1){
                    $("#uploadfilebtn").addClass("am-disabled");
                    $("#checkfile").addClass("am-disabled");
                    //$("#checkfile").text("no files");
                }
                $(this).parent().remove();
            });
            divNode.append(iNode);
            divNode.append(' ' + this.name);
            divNode.append($("<br/>"));
            $(".am-offcanvas-content").append(divNode);
        });
        $("#uploadfilebtn").removeClass("am-disabled");
        $("#checkfile").removeClass("am-disabled");
        //$("#checkfile").text("check files");
    });

    $("#selectFileBtn").hover(function(){
        $(this).css("color", "#ffffff");
        $(this).css("font-size", "180%");
        $(this).text("select file");
    }, function(){
        $(this).text("1");
        $(this).css("font-size", "600%");
        this.blur();
    });

    $("#checkfile").hover(function(){
        $(this).css("color", "#ffffff");
        $(this).css("font-size", "180%");
        $(this).text("check file");
    }, function(){
        $(this).text("2");
        $(this).css("font-size", "600%");
        this.blur();
    });

    $("#uploadfilebtn").hover(function(){
        $(this).css("color", "#ffffff");
        $(this).css("font-size", "180%");
        $(this).val("upload file");
    }, function(){
        $(this).val("3");
        $(this).css("font-size", "600%");
        this.blur();
    });

    $("#runAlgorithmBtn").hover(function(){
        this.blur();
        $(this).css("color", "#ffffff");
        $(this).css("font-size", "180%");
        $(this).val("start !");
    }, function(){
        $(this).val("4");
        $(this).css("font-size", "600%");
        this.blur();
    });


    // ajaxFileUpload 上传完成后的动作
    function finishUpload(message){
        // 关闭"上传文件中"视图
        $("#my-modal-loading").modal('close');
        $('.am-offcanvas-content').html('');
        $("#alertcontent").text(message);
        // 打开"确认收到"提示框
        $("#my-alert").modal("open");
        setTimeout(function(){
            $("#my-alert").modal('close');
        }, 1500);
        $("#uploadfilebtn").addClass("am-disabled");
        $("#checkfile").addClass("am-disabled");
    }

    $("#uploadfilebtn").click(function(){
        // 打开"上传文件中"视图
        this.blur();
        $("#uploading").text("uploading ₍ↂ_ↂ₎ ...")
        $("#my-modal-loading").modal('open');
        var algorId = $("input:hidden").val();
        args = {"algorId": algorId};
        $.ajaxFileUpload({
            url: 'fileUpload.do',
            secureuri: false,
            dataType: 'json',
            data: args,
            fileElementId: 'inputfile',
            success: function(data){
                if(data == "success"){
                    finishUpload('Have received your files ^_^!');
                    // 当输入文件上传成功才能开启运行算法按钮
                    $("#runAlgorithmBtn").removeClass("am-disabled");
                } else if(data == "failed"){
                    finishUpload('I did not receive your files >_<!');
                }
            },
            error: function(data){
                finishUpload('I did not receive your files >_<!');
            }
        });
    });

    // 跳转到运行算法界面
    $("#runAlgorithmBtn").click(function(){
        this.blur();
        var url = this.name;
        window.location.href = url;
    });
});
