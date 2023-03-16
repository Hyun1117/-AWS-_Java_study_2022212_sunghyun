class InforMationEvent {
    static #instance = null;
    static getInstance() {
        if (this.#instance == null) {
            this.#instance = new InforMationEvent();
        }
        return this.#instance;
    }

    addEventPhotoChangeClick() {
        const infoPhoto = document.querySelector(".info-photo");
        infoPhoto.onclick = () => {
            const photoFile = document.querySelector(".photo-file");
            photoFile.click();
        }
    }

    addEventPhotoChange() {
        const photoFile = document.querySelector(".photo-file");
        photoFile.onchange = () => {
            fileService.getInstance().changePhoto();
        }
    }

    addEventAboutMeModifyClick() {
        const aboutMeModifyButton = document.querySelector(".m-aboutme");
        aboutMeModifyButton.onclick = () => {
            const aboutMeSaveButton = document.querySelector(".s-aboutme");
            aboutMeSaveButton.classList.remove("button-hidden");
            aboutMeModifyButton.classList.add("button-hidden");
            
            const infoInputContainers = document.querySelectorAll(".info-input-container");
            infoInputContainers.forEach(infoInputContainer => {
                infoInputContainer.querySelector(".info-input").disabled = false;
            });
        }
    }

    addEventAboutMeSaveClick() {
        const aboutMeSaveButton = document.querySelector(".s-aboutme");
        aboutMeSaveButton.onclick = () => {
            const aboutMeModifyButton = document.querySelector(".m-aboutme");
            aboutMeModifyButton.classList.remove("button-hidden");
            aboutMeSaveButton.classList.add("button-hidden");
            
            const infoInputContainers = document.querySelectorAll(".info-input-container");
            infoInputContainers.forEach(infoInputContainer => {
                console.log(infoInputContainer.querySelector(".info-input").value);
                infoInputContainer.querySelector(".info-input").disabled = true;
            });
        }
    }


    addEventIntroduceModifyClick() {
        const IntroduceModifyButton = document.querySelector(".m-introduce");
        IntroduceModifyButton.onclick = () => {
            const IntroduceSaveButton = document.querySelector(".s-introduce");
            IntroduceSaveButton.classList.remove("button-hidden");
            IntroduceModifyButton.classList.add("button-hidden");
           
            const introduceInput = document.querySelector(".introduce-input");
            introduceInput.disabled = false;
        }
    }

    addEventIntroduceSaveClick() {
        const IntroduceSaveButton = document.querySelector(".s-introduce");
        IntroduceSaveButton.onclick = () => {
            const IntroduceModifyButton = document.querySelector(".m-introduce");
            IntroduceModifyButton.classList.remove("button-hidden");
            IntroduceSaveButton.classList.add("button-hidden");
            
            const introduceInput = document.querySelector(".introduce-input");
            introduceInput.disabled = true;
        }
    }
}

class fileService {
    static #instance = null;
    static getInstance() {
        if (this.#instance == null) {
            this.#instance = new fileService();
        }
        return this.#instance;
    }

    changePhoto() {
        const photoFrom = document.querySelector(".photo-form");
        const formData = new FormData(photoFrom);//FromData 내장객체
        const fileValue = formData.get("file");
        this.showPreview(fileValue);
    }

    showPreview(fileValue) {
        const fileReader = new FileReader();

        fileReader.readAsDataURL(fileValue);//event가 발생

        fileReader.onload = (e) => {//event를 매개변수로 받음
            const photoImg = document.querySelector(".info-photo img");
            photoImg.src = e.target.result;//event의 결과값

        }
    }

}


//     addEventInput(){
//     const modifyButtons = document.querySelectorAll(".modify-button");
//     const infoInputs = document.querySelectorAll(".info-input");
//     const introduceInfo = document.querySelector(".introduce-input");
//     for(let i = 0; i<modifyButtons.length; i++){
//         modifyButtons[i].onclick = () =>{
//             if(modifyButtons[i].classList.contains("m-aboutme")){
//                 modifyButtons[i].classList.add("button-hidden");
//                 infoInputs.forEach(infoinput => {
//                     infoinput.disabled = false;
//                 });
//                 modifyButtons[i+1].classList.remove("button-hidden");
//             }else if(modifyButtons[i].classList.contains("s-aboutme")){
//                 modifyButtons[i].classList.add("button-hidden");
//                 infoInputs.forEach(infoinput => {
//                     infoinput.disabled = true;
//                 });
//                 modifyButtons[i-1].classList.remove("button-hidden");

//             }
//             if(modifyButtons[i].classList.contains("m-introduce")){
//                 modifyButtons[i].classList.add("button-hidden");
//                 introduceInfo.disabled = false;
//                 modifyButtons[i+1].classList.remove("button-hidden");

//             } else if(modifyButtons[i].classList.contains("s-introduce")){
//                 modifyButtons[i].classList.add("button-hidden");
//                 introduceInfo.disabled = true;
//                 modifyButtons[i-1].classList.remove("button-hidden");
//             }

//         }
//     }
// }