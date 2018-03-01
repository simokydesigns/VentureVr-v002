function onInit(){
	
	//alert("video player is loaded");
	
	var sContainer, sVid, sPlayBtn, sMuteBtn, sSlider,
	 sVolSlider, sCurTimeText, sDurTimeText, sFullScreen, 
	 sSceneBox, sLaunchBtn;
	
	//Set Object references
	sSceneBox = document.querySelector('a-scene');
	sContainer = document.getElementById("video_player_box");
    sVid = document.getElementById("video_player_1");
	sControls = document.getElementById("video_controls_bar");
	sPlayBtn = document.getElementById("play_pause_btn");
	sMuteBtn = document.getElementById("mute_btn");
	sSlider = document.getElementById("video_slider");
	sVolSlider = document.getElementById("sound_slider");
	sCurTimeText = document.getElementById("cur_time_text");
	sDurTimeText = document.getElementById("dur_time_text");
    sLaunchBtn = document.getElementById("view_btn"); 
	
	
	//Add event listeners
	sPlayBtn.addEventListener('click', playPause, false);
	sMuteBtn.addEventListener('click', mute, false);
	sSlider.addEventListener('change', vidSeek, false);
	sVid.addEventListener('timeupdate', vidSeekTimeUpdate, false);
	sVolSlider.addEventListener('change', setVolume, false);
	sLaunchBtn.addEventListener('click', launch, false); 
	
	sCurTimeText.innerHTML = "00:00/";
	vidDuration(); 
	
	window.onkeydown = function(e) {
		 if (e.keyCode == 27) { // escape key maps to keycode `27`
		     sSceneBox.exitVR();
		     sSceneBox.setAttribute('embedded', true);
		}
	}; 
		



	function playPause(){
		
		if(sVid.paused){
			sVid.play();
			sPlayBtn.innerHTML = "Pause";
		}else{
			sVid.pause();
			sPlayBtn.innerHTML = "Play";
		}
		
	};
	function mute(){
		if(sVid.muted){
			sVid.muted = false;
			sMuteBtn.innerHTML = "Mute";
		}else{
			sVid.muted = true;
			sMuteBtn.innerHTML = "Unmute";
		}
	};
	function launch(){
		
		sSceneBox.setAttribute('embedded', false);
		sSceneBox.enterVR();
		
	};
	
	function vidSeek(){
		var iSeekPos = sVid.duration * (sSlider.value / 100);
		sVid.currentTime = iSeekPos;
	};
	
	function vidDuration(){
		var iDurMins = Math.floor(sVid.duration / 60);
		var iDurSecs = Math.floor(sVid.duration - iDurMins * 60);
		
		if(iDurSecs < 10){
			iDurSecs = "0" + iDurSecs;	
		}
		if(iDurMins < 10){
			iDurMins = "0" + iDurMins;	
		}
		sDurTimeText.innerHTML = iDurMins+ ":" + iDurSecs;
	};
	
	function vidSeekTimeUpdate(){
		var newTime = sVid.currentTime * (100 / sVid.duration);
		sSlider.value = newTime;
		
		var iCurMins = Math.floor(sVid.currentTime / 60);
		var iCurSecs = Math.floor(sVid.currentTime - iCurMins * 60);
	
		if(iCurSecs < 10){
			iCurSecs = "0" + iCurSecs;
		}
		if(iCurMins < 10){
			iCurMins = "0" + iCurMins;
		}
	
		sCurTimeText.innerHTML = iCurMins+ ":" + iCurSecs + "/";
		
	};
	
	
	function setVolume(){
		sVid.volume = sVolSlider.value / 100;
	};
	
	function setFullScreen(){
		if(sVid.requestFullScreen){
			sVid.requestFullScreen();
		}else if(sVid.webkitRequestFullScreen){
			sVid.webkitRequestFullScreen();
		}else if(sVid.mozRequestFullScreen){
			sVid.mozRequestFullScreen();
		}
	};
};




