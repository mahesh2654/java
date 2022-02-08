import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from 'src/model/book';
import { Member } from 'src/model/member';


@Injectable({
  providedIn: 'root',
})
export class LibraryService {

  constructor(private http: HttpClient) {}

  bookUrl: string = 'http://localhost:8080/books';
  memberUrl: string = 'http://localhost:8080/members';

  getAllBooks() :Observable<any>{
      return this.http.get(this.bookUrl)
  }

  getBooksBySubject(subject:string):Observable<any>{
    return this.http.get(`${this.bookUrl}/getAll/${subject}`)
  }

  getAllMembers(): Observable<any>{
    return this.http.get(this.memberUrl);
  }

  deleteBook(bookId:number):Observable<any>{
    return this.http.delete(`${this.bookUrl}/${bookId}`)
  }
  deleteMember(memId:number):Observable<any>{
    return this.http.delete(`${this.memberUrl}/${memId}`)
  }

  getAllSubjects():Observable<any>{
    return this.http.get(`${this.bookUrl}/getSubjects`)
  }

  saveBook(book:Book):Observable<any>{

    return this.http.post(`${this.bookUrl}`,book)
  }

  saveMember(member:Member):Observable<any>{

    return this.http.post(`${this.memberUrl}`,member)
  }

  issueBook(bookId:number,memberId:number):Observable<any>{

    return this.http.put(`${this.bookUrl}/issue/${memberId}/${bookId}`,null)
  }

  returnBook(bookId:number,memberId:number):Observable<any>{

    return this.http.put(`${this.bookUrl}/return/${memberId}/${bookId}`,null)
  }
 
}
