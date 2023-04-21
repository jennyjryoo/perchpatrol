export class Form {

    zip: string ="";
    distance: number = 0;

    public constructor(init?: Partial<Form>) {
        Object.assign(this, init);
    }
    
}
