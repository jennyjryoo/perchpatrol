export class Form {

    zip: string ="";
    distance: number = 0;
    type: string = "";

    public constructor(init?: Partial<Form>) {
        Object.assign(this, init);
    }
    
}
