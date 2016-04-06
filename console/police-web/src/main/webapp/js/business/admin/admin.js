/**
 * Created by wangshaobo on 2015/7/16.
 */
    /**
     * 属性解释
     * data-date="12-04-2013"  表示显示框中的默认时间
     * data-date-format="dd-mm-yyyy" 组件显示格式，显示到输入框中
     * data-link-field="dtp_input2" 链接的输入框。在此div外面 写入一个id=data-link-field值的输入框。
     * data-link-format="yyyy-mm-dd" 链接的输入框显示格式
     *
     * 日期格式：常用如下：
     * •yyyy-mm-dd
     * •yyyy-mm-dd hh:ii
     * •yyyy-mm-ddThh:ii
     * •yyyy-mm-dd hh:ii:ss
     * •yyyy-mm-ddThh:ii:ssZ

     */
    $('.form_date').datetimepicker({
        language: 'zh-CN',//语言  Currently ships with English ('en'), German ('de'), Brazilian ('br'), and Spanish ('es') translations, but others can be added (see I18N below)
        weekStart: 1,//星期的第几天Day of the week start. 0 (Sunday) to 6 (Saturday)
        todayBtn:  1,// 当日按钮 If true or "linked", displays a "Today" button at the bottom of the datetimepicker to select the current date. If true, the "Today" button will only move the current date into view; if "linked", the current date will also be selected.
        autoclose: 1,// 自动关闭，当日期选择后，是否自动关闭显示框
        // 1 or true 自动关闭 autoclose:true
        // Boolean. Default: false
        // Whether or not to close the datetimepicker immediately when a date is selected.

        todayHighlight: 1,//今日是否高亮
        startView: 2, //开始打开的显示，2表示月份 The view that the datetimepicker should show when it is opened. Accepts values of :
        //    •0 or 'hour' for the hour view
        //    •1 or 'day' for the day view
        //    •2 or 'month' for month view (the default)
        //    •3 or 'year' for the 12-month overview
        //    •4 or 'decade' for the 10-year overview. Useful for date-of-birth datetimepickers.

        minView: 2,//最小显示 2表示月份 ，通过此属性控制组件是否显示月份或者时间
        // Number, String. Default: 0, 'hour'
        // The lowest view that the datetimepicker should show

        forceParse: 1  //是否执行格式解析。当用户输入非法日期格式时，组件会按照format去解析，显示 0表示不解析，1表示解析
        //Whether or not to force parsing of the input value when the picker is closed.
        // That is, when an invalid date is left in the input field by the user,
        // the picker will forcibly parse that value, and set the input's value to the new, valid date,
        // conforming to the given  format .
    });
//使用如下：

//<div class="form-group">
//    <label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>
//<div class="input-group date form_date col-md-5" data-date="" data-date-format="dd-mm-yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
//    <input class="form-control" size="16" type="text" value="">
//    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
//<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
//</div>
//<input type="hidden" id="dtp_input2" value="" /><br/>
// </div>
//
//<div class="form-group">
//    <label  class="col-md-2 control-label">Date Picking2</label>
//<div class="input-group date form_date col-md-5" data-date="12-04-2013" data-date-format="dd-mm-yyyy">
//    <input class="form-control" size="16" type="text" value="">
//    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
//<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
//</div>
//</div>