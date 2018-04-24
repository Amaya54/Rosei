function show(id3){
		var id1=document.getElementById("menus");
		id1.style.visibility="visible";
		id1.style.zIndex="31";
		//var id2=document.getElementById("arrow");
		//id2.style.visibility="visible";
		//id2.style.zIndex="31";alert(id2.id);
	if(id3=="mess1")
		id2.style.top="44%";
	
	else if(id3=="mess2")
		id2.style.top="59%";
} 
function remove1(){
	var id1=document.getElementById("menus");
	id1.style.visibility="hidden";	
	id1.style.zIndex="-1";
	var id2=document.getElementById("arrow");
	id2.style.visibility="hidden";
	id2.style.zIndex="-1";
}

var flg=0;
var anime;
function move(id1){//if(id1.id=="l6") a();
	if(flg==1)
	{	
		//var z=document.getElementById('x');
		document.body.removeChild(anime);
		//anime.remove();
		document.getElementById('move').style.webkitAnimation="";
	}
	
	var str="frame" + id1.id.charAt(1);//alert(str);
	var id2=document.getElementById(str);
	var id3=document.getElementById('move');
	var y=id3.offsetLeft;
	var x=-parseInt((parseInt(id2.offsetLeft)-30));
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
	document.getElementById('move').style.webkitAnimation="move 0.5s ease-out";
	flg=1;
}
var uflag=0;function uDrop(){	
var id1=document.getElementById('user');
id1.style.height="140px";	
id1.style.background="rgba(65,170,7,0.8)";
id1.style.webkitAnimation="userDrop 1s ease-out";uflag=2;
}
function userNat(id1){if(id1.id=='user')
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



var openFlag=0;
var omg=0;
function open1(id1){
	omg=omg+1;
	var id2=document.getElementById('mess1');
	var id3=document.getElementById('mess2');
	var id4=document.getElementById('arrow01');
	var id5=document.getElementById('arrow02');
	addKeyFrame(id2,0,-38,0,90,90,0,0);
	addKeyFrame(id3,0,38,0,90,-90,0,0);
	addArrow(id4,25,-5,78,70,90,60,0);
	addArrow(id5,25,45,78,70,90,120,0);
	//openFlag=openFlag+1;
	omg=omg+1;
}

function addKeyFrame(id1,topi,topf,lefti,leftf,rotatei,rotatef,a){//alert("here");
	id1.style.webkitAnimation=' ';
	var name=id1.id+a;
	var x=document.createElement('style');
	x.type='text/css';
	x.id='x';
	var y='@-webkit-keyframes '+name+'{0%{top:'+topi+'px;left:'+lefti+'px;-webkit-transform:rotate('+rotatei+'deg);} 100%{top:'+topf+'px;left:'+leftf+'px;-webkit-transform:rotate('+rotatef+'deg);}}';
	var z=document.createTextNode(y);
	x.appendChild(z);
	document.body.appendChild(x);
	var anime=name+' '+'0.5s ease-out';
	//id1.style.webkitAnimation=' ';
	id1.style.webkitAnimation=anime;
	id1.style.top=topf;
	id1.style.left=leftf;
	//id1.style.setAttribute('border-left','50px solid orange');
	document.getElementById('arrow1').style.borderBottom='50px solid rgba(3,131,163,1)';
	document.getElementById('arrow2').style.borderBottom='50px solid rgba(3,131,163,1)';//alert(y);
	//openFlag=openFlag+'1';
}

/*function close1(id5){
	var id1=document.getElementById('menu');
	var id2=document.getElementById('mess1');
	var id3=document.getElementById('mess2');
	addKeyFrame(id2,-70,0,90,0,0,90);
	addKeyFrame(id3,70,0,90,0,0,-90);
	openFlag=openFlag+1;
}*/

function addArrow(id1,topi,topf,lefti,leftf,rotatei,rotatef,a){
	var name=id1.id+a;
	var x=document.createElement('style');
	x.type='text/css';
	x.id='x';
	var y='@-webkit-keyframes '+name+'{0%{top:'+topi+'px;left:50px;-webkit-transform:rotate('+rotatei+'deg);} 30%{top:'+topi+'px;left:'+lefti+'px;-webkit-transform:rotate('+rotatei+'deg);} 100%{top:'+topf+'px;left:'+leftf+'px;-webkit-transform:rotate('+rotatef+'deg);}}';
	var z=document.createTextNode(y);
	x.appendChild(z);
	document.body.appendChild(x);
	//id1.style.webkitAnimation=' ';
	id1.style.webkitAnimation=name+' '+'0.3s ease-out';
	id1.style.webkitTransform='rotate('+rotatef+'deg)';
	id1.style.top=topf;
	id1.style.left=leftf;
	//openFlag=openFlag+'1';
}

function open2(id1,lefti,leftf,a){
	var name=id1.id+a;//alert(name);
	var t='arrow'+name.charAt(4);
	var id2=document.getElementById(t);
	var id3=document.getElementById('table'+name.charAt(4));
	id3.style.visibility="visible";
	var x=document.createElement('style');
	x.type='text/css';
	x.id='x';
	var y='@-webkit-keyframes '+name+'{0%{left:'+lefti+'px;}  100%{left:'+leftf+'px;}}';
	var z=document.createTextNode(y);
	x.appendChild(z);
	document.body.appendChild(x);
	//id2.style.webkitAnimation=' ';
	id2.style.webkitAnimation=name+' '+'0.3s ease-out';
	id2.style.left='78px';
	if(name.charAt(4)=='1') var s='2';
	else var s='1';
	var u='arrow'+s; 
	var id4=document.getElementById(u);
	id4.style.left='40px';
	id4.style.webkitAnimation='';
	var id5=document.getElementById('table'+s);
	id5.style.visibility="hidden";//alert();
	openFlag=openFlag+1;
}

function close2(){
	if(omg!=0)
	{
		var id1=document.getElementById('mess1');
		var id2=document.getElementById('mess2');
		var id3=document.getElementById('arrow1');
		var id4=document.getElementById('arrow2');
		var id5=document.getElementById('table1');
		var id6=document.getElementById('table2');
		var id7=document.getElementById('arrow01');
		var id8=document.getElementById('arrow02');
		/*id1.style.webkitAnimation='m1 9.8s';
		id2.style.webkitAnimation='m1 9.8s ';
		id3.style.webkitAnimation=' m1 9.8s';
		id4.style.webkitAnimation='m1 9.8s ';
		id5.style.webkitAnimation='m1 9.8s ';
		id6.style.webkitAnimation='m1 9.8s ';
		id7.style.webkitAnimation='m1 9.8s ';
		id8.style.webkitAnimation='m1 9.8s ';*/
		addKeyFrame(id1,-38,0,90,0,0,90,1);
		addKeyFrame(id2,38,0,90,0,0,-90,1);
		addArrow(id8,45,25,70,40,120,90,1);
		addArrow(id7,-5,25,70,40,60,90,1);
		id5.style.visibility='hidden';
		id6.style.visibility='hidden';
		//open2(id1,78,40,1)
		//open2(id2,78,40,1)
		id4.style.left='40px';
		id3.style.left='40px';
	}
}
function check(id1){
	openFlag=openFlag-1;
	if(openFlag==0) close2();
}







