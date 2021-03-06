<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>复选框Demo</title>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            // 全选
            $("#btnCheckAll").bind("click", function () {
                $("[name = chkItem]:checkbox").attr("checked", true);
            });
 
            // 全不选
            $("#btnCheckNone").bind("click", function () {
                $("[name = chkItem]:checkbox").attr("checked", false);
            });
 
            // 反选
            $("#btnCheckReverse").bind("click", function () {
                $("[name = chkItem]:checkbox").each(function () {
                    $(this).attr("checked", !$(this).attr("checked"));
                });
            });
 
            // 全不选
            $("#btnSubmit").bind("click", function () {
                var result = new Array();
                $("[name = chkItem]:checkbox").each(function () {
                    if ($(this).is(":checked")) {
                        result.push($(this).attr("value"));
                    }
                });
 
                alert(result.join(","));
            });
        });
    </script>
</head>
<body>
    <div>
        <input name="chkItem" type="checkbox" value="今日话题" />今日话题
        <input name="chkItem" type="checkbox" value="视觉焦点" />视觉焦点
        <input name="chkItem" type="checkbox" value="财经" />财经
        <input name="chkItem" type="checkbox" value="汽车" />汽车
        <input name="chkItem" type="checkbox" value="科技" />科技
        <input name="chkItem" type="checkbox" value="房产" />房产
        <input name="chkItem" type="checkbox" value="旅游" />旅游
    </div>
    <div>
        <input id="btnCheckAll" type="button" value="全选" />
        <input id="btnCheckNone" type="button" value="全不选" />
        <input id="btnCheckReverse" type="button" value="反选" />
        <input id="btnSubmit" type="button" value="提交" />
    </div>
</body>
</html>