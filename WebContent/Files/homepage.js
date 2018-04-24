var flag1=0;
//var x=document.getElementById('t1');
//var y=document.getElementById('t2');
var flag=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];

	//alert(navigator.appName);

/*function move(id1){
	var str=id1.id;
	var id2;
	if(str=="t1")
		str=str.replace(1,2);
	else if(str=="t2")
		str=str.replace(2,1);
	id2=document.getElementById(str);
	str=id1.id;
	id1.id=id2.id;
	id2.id=str;
	if(flag1==0)
	{
		document.getElementById('single').style.webkitAnimation="sleft 1s";
		document.getElementById('single').style.left="-920px";
		document.getElementById('coupon').style.webkitAnimation="rleft 1s";
		document.getElementById('coupon').style.left="80px";
		flag1=1;
	}
	else if(flag1==1)
	{
		document.getElementById('single').style.webkitAnimation="sright 1s";
		document.getElementById('single').style.left="80px";
		document.getElementById('coupon').style.webkitAnimation="rright 1s";
		document.getElementById('coupon').style.left="1000px";
		flag1=0;
	}
}*/


var flg=0;
var anime;
function move(id1){
	if(flg==1)
	{	
		//var z=document.getElementById('x');
		document.body.removeChild(anime);
		//anime.remove();
		document.getElementById('move').style.webkitAnimation="";
	}
	var str=id1.innerHTML;	
	var id2=document.getElementById(str);
	var id3=document.getElementById('move');
	var y=id3.offsetLeft;
	var x=-parseInt((parseInt(id2.offsetLeft)-80));
	id3.style.left=x
	keyFrame(y,x);
	//id3.style.webkitAnimation="move 1s ease-out";
	
}

function keyFrame(from,to)
{
	anime=document.createElement('style');
	anime.type='text/css';
	anime.id='x';
	var x='@-webkit-keyframes move{from{left:' + parseInt(from) + 'px;} to{left:'+ parseInt(to) +'px;} }';
	var key=document.createTextNode(x);
	anime.appendChild(key);
	document.body.appendChild(anime);
	document.getElementById('move').style.webkitAnimation="move 1s ease-out";
	flg=1;
}


//	var flag=new Array('0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',); </script>
var frame;
var time;
function change2(id1){
	//var str=new String(id1.id);//alert("change 2 in" + id1.id);
	flagIndex=index(id1);
	if(flag[parseInt(flagIndex)]==0)
	{
		//complement(id1);
		modify(id1,1);
		//addFrame(id1);
	}
	else if(flag[parseInt(flagIndex)]==1)
	{ 
		//complement(id1);
		modify(id1,2);
		//addFrame(id1);
	}
	else
	{
		//complement(id1);
		modify(id1,0);
	}	//alert("change 2 out" + id1.id);
	//delay(2);alert("HERE");
	//setTimeout("removeFrame(id1)",5000);alert(id1);
	//removeFrame(id1);
}



var colorVeg="rgba(0,100,0,0.8)";
//var colorNonVeg="rgba(128,64,0,0.7)";
var colorNonVeg="rgba(237,28,36,0.5)";
var colorInit="rgba(65,170,7,0.5)";


function modify(id1,choice){//alert("modify in" + id1.id);
	var str=new String(id1.id);
	var DisplayId=str.substring(5,7)+str.charAt(4);//corresponding id in the matrix 
	var id2=document.getElementById(DisplayId);
	var InnerText='M'+' '+str.charAt(4);//mmatrix division values
	flagIndex=parseInt(index(id1));
	if(choice==1)
	{
		id1.style.background=colorNonVeg;
		id2.innerHTML=InnerText;  
		id2.style.background=colorNonVeg;
		flag[parseInt(flagIndex)]=1;
		var pop=document.getElementById('nonveg');
		id1.appendChild(pop);
		pop.style.webkitAnimation="pop1 0.5s ease-out";
		//update();
	}
	else if(choice==2)
	{
		id1.style.background=colorVeg;
		id2.style.background=colorVeg;
		id2.innerHTML=InnerText;  
		flag[parseInt(flagIndex)]=2;
		var pop=document.getElementById('veg');
		id1.appendChild(pop);
		pop.style.webkitAnimation="pop2 0.5s ease-out";
		//update();
	}
	else
	{
		id1.style.background=colorInit;
		id2.innerHTML=' ';  
		id2.style.background=colorInit;
		flag[parseInt(flagIndex)]=0;
	}//alert("modify out" + id1.id);
}
/*function complement(id1){//alert("complement in" + id1.id);
	var str=id1.id;
	var t=id1.id.charAt(4);
	if(t=='1')
	{
		str=str.replace("mess1","mess2");
		var id2=document.getElementById(str);
		id2.style.background=colorInit;
		flag[parseInt(index(id2))]=0;
	}
	else if(t=='2')
	{
		str=str.replace("mess2","mess1");
		var id2=document.getElementById(str);
		id2.style.background=colorInit;
		flag[parseInt(index(id2))]=0;
	}//alert("complement out" + id1.id);
}*/
function index(id1){//alert("index in" + id1.id);
	str=id1.id;
	var flagIndex=0;//the flag index corresponding to the id = 6*(d-1)+2*(a-1)+(b-1);
	var a=0;//represents the meal type	
	
		if(str.charAt(5)=='b')
			a=1;
		else if(str.charAt(5)=='l')
			a=2;
		else if(str.charAt(5)=='d')
			a=3;
	var b=parseInt(str.charAt(4));//represents the mess no.
	var d=parseInt(str.charAt(6));//reprents the date serial no.
	flagIndex=6*(parseInt(d)-1)+2*(parseInt(a)-1)+(parseInt(b)-1);//alert("index out" + id1.id);
	return flagIndex;
}
/*function addFrame(id1){//alert("addframe in" + id1.id);
	
	//document.getElementById('frame').removeChild('frame');
	var a=flag[index(id1)];
	frame=document.createElement('div');
	frame.id="frame";
	id1.appendChild(frame);
	if(a==1)
		frame.innerHTML="VEG";
	else 
		frame.innerHTML="NON-VEG";	
	//alert("addframe in" + id1.id);
}
function removeFrame(id1){
	var id2=document.getElementById(frame.id);
	id1.removeChild(id2);
	//window.clearInterval(time);
}
function delay(x){
	var a=new Date;
	var b=a.getSeconds();
	var c=a.getSeconds();
	while(b<c+x)
	{
		a=new Date;
		b=a.getSeconds();
	}
}
*/

var f=0;

function menu(){
	var x=document.getElementById('menu');
		x.style.top="33%";	
		x.style.webkitAnimation="open 1s ease-out";	
		f=2;
		//x.style.top="33%";
	
}



function natural(id1){
	
	if(id1.id=='menu')
		f=f+2;
	else 
		f=f-2;
	if(f<=0)
	{
		var x=document.getElementById('menu');
		x.style.webkitAnimation="";
		x.style.top="100%";
	}
	userNat(id1);
}

var uflag=0;
function uDrop(){
	var id1=document.getElementById('user');
	id1.style.height="140px";
	id1.style.background="rgba(65,170,7,0.8)";
	id1.style.webkitAnimation="userDrop 1s ease-out";
	uflag=2;
}


function userNat(id1){

if(id1.id=='user')
		uflag=uflag+2;
	else 
		uflag=uflag-2;
	if(uflag<=0)
	{
		var x=document.getElementById('user');
		x.style.webkitAnimation="";
		x.style.height="30px";
	}





}