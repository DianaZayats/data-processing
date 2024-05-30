import { Albums } from "./albums"

export interface Api {
    _embedded: {
        albums: Albums[]
    },
    _links: {
        self: {
            href: string
        },
        profile: {
            href: string
        }
    }
    page : {
        size : number,
        totalElements : number,
        totalPages : number
        number : number
      }
}