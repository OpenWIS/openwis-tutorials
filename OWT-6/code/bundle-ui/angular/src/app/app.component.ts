import { Component } from '@angular/core';
import { ElementRef } from '@angular/core';
import { AfterViewChecked, ViewChild, OnInit } from '@angular/core';

import { MessageService } from "../service/service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [MessageService],
})


export class AppComponent implements OnInit, AfterViewChecked {

  @ViewChild('scrollme') private myScrollContainer: ElementRef;
  @ViewChild('messageBox') private messageBox: HTMLInputElement;

  title = 'app';
  messages: Object[] = [];
  SERVICE_URL = '/cxf/api/echo/';
  private textBoxMessage: String;

  constructor(private messageService: MessageService) { }

  printData() {

    if (this.textBoxMessage.length > 0) {
      var msgClone = new String(this.textBoxMessage);
      this.textBoxMessage = '';
      this.printlocalMessage(msgClone);
      this.callService(msgClone);
    }
  }

  private printlocalMessage(message: String) {
    this.addMessageTologQueue(message, false);
  }

  private callService(message) {
    var messageObject = new Object();
    messageObject['message'] = message;
    if (message.length > 0) {
      var thiz = this;
      this.messageService.create(this.SERVICE_URL, messageObject).then((result) => {
        this.addMessageTologQueue(result.message, true);
      }).catch((ex) => {
        console.error('Error fetching response', ex);
      });
    }
  }

  addMessageTologQueue(text: String, isFromService: Boolean): void {
    var message = new Object();
    message['text'] = text;
    message['when'] = new Date().toLocaleTimeString();
    if (isFromService) {
      message['from'] = 'echo';
    } else {
      message['from'] = 'user';
    }

    this.messages.push(message);
  }

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




