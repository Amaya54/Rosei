


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
id1.style.height="160px";	
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



	