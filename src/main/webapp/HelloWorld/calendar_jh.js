var calendar_path="HelloWorld/";
document.write('<iframe width="174" height="189" name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="'+calendar_path+'ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;"></iframe>');

function PutCalBtn(objId){
document.write('<a href="javascript:void(0)" onclick="if(gfPop)gfPop.fPopCalendar(document.getElementById(\''+objId+'\'));return false;" ><img class="PopcalTrigger" align="absmiddle" src="'+calendar_path+'calbtn.gif" width="34" height="22" border="0" alt=""></a>');
document.getElementById(objId).readOnly=true;
}

function popCalendar(objectOrId){
	if(typeof(objectOrId)=="string")objectOrId=document.getElementById(objectOrId);
	if(gfPop)gfPop.fPopCalendar(objectOrId);	
}