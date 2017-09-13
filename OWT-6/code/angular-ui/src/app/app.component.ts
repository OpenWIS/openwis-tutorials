import { Component } from '@angular/core';
import { ElementRef } from '@angular/core'; 
import { AfterViewChecked, ViewChild, OnInit } from '@angular/core';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})


export class AppComponent implements OnInit, AfterViewChecked {

  @ViewChild('scrollme') private myScrollContainer: ElementRef;

  title = 'app';
  chatroom: string[] = [];
  home: string[] = []; //["dimi1","","dimi2","dimi3","","dimi4"];
  away: string[] = []; // ["","jv1","","","jv2","" ];
// 8a exoume 2 listes mia pou 8a einai ta chat tou home kai mia pou 8a einai tou away..
// 8a bazoume kai tis 2 sthn chatroom kai 8a 


  chatroomText: string;
  message: string = '';

// user messages came through here:
  sendData(message: string) {

    if (message.length > 0) 
    this.home.push(message);
    this.away.push("");
    this.logText(message);
    this.message = '';

  }


  sendDataMockService(message){
    if (message.length > 0) {
      this.away.push(message);
      this.home.push("");
      this.logText(message);
      this.message = '';
    }
  }


  private logText(text: string): void {
   
      this.chatroom.push(text);
      this.chatroomText = this.chatroom.join("\n");

   
  }


  // we scoll to bottom chat so the last message will be always desplayed.
  ngOnInit() {

    this.scrollToBottom();
  }

  ngAfterViewChecked() {
    this.scrollToBottom();

  }
  scrollToBottom(): void {
    try {

      this.myScrollContainer.nativeElement.scrollTop = +this.myScrollContainer.nativeElement.scrollHeight;

    } catch (err) { }
  }

}




