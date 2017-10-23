Front library
name: sisyphus.js
link: http://sisyphus-js.herokuapp.com/ , https://www.smashingmagazine.com/2011/12/sisyphus-js-client-side-drafts-and-more/
설명: 브라우저의 캐시에 jquery를 사용하여 특정 input text들의 값을 저장한다.
설정:  
    {
        excludeFields: [],  //포함하지 않을 필드를 넣어준다 ex:$( "#advanced_form_country" )
        customKeySuffix: "", //데이터를 불러올때 url별 구분이 필요할경우(#hashtag 등으로 활용하면될듯)
        locationBased: false,
        timeout: 0, //데이터 저장주기 (초)
        autoRelease: true,
        onSave: function() {}, //저장시 받을 콜백
        onBeforeRestore: function() {}, //데이터를 불러오기전 불러올지,말지를 판단하기 위함. false 리턴시 불러오지않음
        onRestore: function() {}, //데이터를 불러올때 받는 콜백
        onRelease: function() {} //브라우저의 데이터를 clear할때 받는 콜백
    }
    
    

